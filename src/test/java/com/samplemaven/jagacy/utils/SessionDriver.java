package com.samplemaven.jagacy.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cucumber.listener.Reporter;
import com.jagacy.Key;
import com.jagacy.Session3270;
import com.jagacy.util.JagacyException;
import com.samplemaven.jagacy.fields.LabelField;

import cucumber.api.Scenario;

public class SessionDriver extends Session3270 {
	
	private final HashMap<RenderingHints.Key, Object> renderingProperties = new HashMap<>();
	
	private static final Logger log = LogManager.getLogger(SessionDriver.class);
	private static final int DEFAULT_TIMEOUT = 5000;
	
	public SessionDriver(String session) throws JagacyException {
		super(session);
	}
	
	/**
	 * 
	 * @param key
	 * @return 
	 */
	public Key pressKey(String key) {
		Map<String, Key> keyBoardMapping = new HashMap<>();
		try {
			keyBoardMapping.put("Enter", writeKey(Key.ENTER));
			keyBoardMapping.put("F24", writeKey(Key.PF24));
			
			return keyBoardMapping.get(key);
		} catch (Exception e) {
			log.error("Cannot find indicated key {} {}", key, e);
		}
		return keyBoardMapping.get(key);
		
	}

	/**
	 * @param labelField
	 * @param text
	 * @return True if text is displayed, False if text is not displayed
	 */
	public boolean waitForTextToAppear(LabelField labelField, String text) {
		try {
			log.debug("Getting value at row [{}] and column [{}]", labelField.getRow(), labelField.getColumn());
			if (waitForPosition(labelField.getRow(), labelField.getColumn(), labelField.getLabelText(), DEFAULT_TIMEOUT)) {
				log.info("Found text [{}]", getTextFromScreen(labelField, text));
				return true;
			}
		} catch (JagacyException je) {
			log.error("Somthing went wrong {}", je);
		} catch (Exception e) {
			log.error("Somthing went wrong {}", e);
		} 
		log.warn("Text is not found in the screen");
		return false;
	}
	
	/**
	 * @param labelField
	 * @param text
	 * @return String from specified Lable row and Lable column
	 * @throws JagacyException
	 */
	public String getTextFromScreen(LabelField labelField, String text) throws JagacyException {
		return readPosition(labelField.getRow(), labelField.getColumn(), text.length());
	}
	
	/**
	 * @param labelField
	 * @param text
	 * @param sc
	 */
	public void inputTextToScreen(LabelField labelField, String text) {
		try {
			writePosition(labelField.getRow(), labelField.getColumn(), text);
		} catch (JagacyException je) {
			log.error("Unable to get the text. {}", je);
		} catch (Exception e) {
			log.error("Something went wrong. {}", e);
		}
	}
	
	/**
	 * Generates a screen shot by using readScreen method.
	 * 
	 * @return screen shot in PNG
	 * @throws Exception
	 *         JagacyException
	 */
	public final byte[] getScreenshot(Scenario scenario) throws Exception {

		// below approach is inspired by solutions given
		// at http://stackoverflow.com/questions/18800717/convert-text-content-to-image

		String screenText = StringUtils.join(readScreen(), "\n");

		renderingProperties.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		renderingProperties.put(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
		renderingProperties.put(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);

		Font font = new Font("Consolas", Font.PLAIN, 12);
		FontRenderContext fontRenderContext = new FontRenderContext(null, true, true);
		BufferedImage bufferedImage = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
		Graphics2D graphics2D = bufferedImage.createGraphics();
		graphics2D.setRenderingHints(renderingProperties);
		graphics2D.setBackground(Color.black);
		graphics2D.setColor(Color.GREEN);
		graphics2D.setFont(font);
		graphics2D.clearRect(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight());

		TextLayout textLayout = new TextLayout(screenText, font, fontRenderContext);

		int count = 0;
		for (String line : screenText.split("\n")) {
			graphics2D.drawString(line, 15, (int) (15 + count * textLayout.getBounds().getHeight() + 0.5));
			count++;
		}
		graphics2D.dispose();

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ImageIO.write(bufferedImage, "PNG", out);
		// Add delay for saving screenshot
		waitForChange(700);
		saveScreenshot(out, scenario);
		return out.toByteArray();
	}

	private void saveScreenshot(ByteArrayOutputStream out, Scenario scenario) {
		
		String screenShotName = new StringBuffer().append(scenario.getName().replace(" ", "_")).append("_")
				.append(new SimpleDateFormat("MM_d_yyyy_HH_mm_ss").format(new Date())).toString();
		
		String screenShotPath = new StringBuffer().append(System.getProperty("user.dir")).append("\\target\\generated-test-sources\\cucumber-reports\\screenshots\\").append(screenShotName)
				.append(".png").toString();
		
		try (FileOutputStream fileOutputStream = new FileOutputStream(new File(screenShotPath))) {
		
			out.writeTo(fileOutputStream);
			Reporter.addScreenCaptureFromPath(screenShotPath);
		} catch (Exception e) {
			log.error("Something went wrong {}", e);
		}
	}
	
	
	
}
