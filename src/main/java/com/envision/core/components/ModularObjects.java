package com.envision.core.components;

public class ModularObjects {

	public static String getXpathForButtonById(String id) throws Exception {
		if (id.isEmpty()) {
			throw new Exception("Empty Value passed, pls check the value");
		}
		return "//button[@id='" + id + "']";
	}

	public static String getXpathForButtonByText(String id) throws Exception {
		if (id.isEmpty()) {
			throw new Exception("Empty Value passed, pls check the value");
		}

		return "//button[contains(text(),'" + id + "')]";
	}

	public static String getXpathForLinkByText(String text) throws Exception {
		if (text.isEmpty()) {
			throw new Exception("Empty Value passed, pls check the value");
		}
		return "//a[contains(text(),'" + text + "')]";
	}

	public static String getXpathForLinkById(String id) throws Exception {
		if (id.isEmpty()) {
			throw new Exception("Empty Value passed, pls check the value");
		}
		return "//a[@id='" + id + "']";
	}

	public static String getXpathForButtonByExactText(String id) throws Exception {
		if (id.isEmpty()) {
			throw new Exception("Empty Value passed, pls check the value");
		}

		return "//button[text()='" + id + "']";
	}

	public static String getXpathForLabelById(String id) throws Exception {
		if (id.isEmpty()) {
			throw new Exception("Empty Value passed, pls check the value");
		}

		return "//label[@id='" + id + "']";

	}

	public static String getXpathForLabelByExactText(String text) throws Exception {
		if (text.isEmpty()) {
			throw new Exception("Empty Value passed, pls check the value");
		}

		return "//label[text()='" + text + "']";
	}

	public static String getXpathForLabelByText(String text) throws Exception {
		if (text.isEmpty()) {
			throw new Exception("Empty Value passed, pls check the value");
		}

		return "//label[contains(text(),'" + text + "')]";
	}

	public static String getXpathForTextBoxById(String id) throws Exception {
		if (id.isEmpty()) {
			throw new Exception("Empty Value passed, pls check the value");
		}

		return "//input[@id='" + id + "']";
	}

	public static String getXpathForTextBoxByPlaceholder(String placeholderText) throws Exception {
		if (placeholderText.isEmpty()) {
			throw new Exception("Empty Value passed, pls check the value");
		}

		return "//input[@placeholder='" + placeholderText + "']";
	}

	public static void main(String[] args) throws Exception {
		System.out.println(getXpathForButtonByExactText("Sign Off"));
	}

	public static String getXpathForElement(String elementName, String type, String value)
			throws Exception {
		String xpath = "";
		switch (elementName) {
		case "Button":
			if (type.contains("text")) {
				xpath = getXpathForButtonByText(value);
			} else if (type.contains("id")) {
				xpath = getXpathForButtonById(value);
			}
			break;
		case "TextBox":
			if (type.contains("placeholder")) {
				xpath = getXpathForTextBoxByPlaceholder(value);
			} else if (type.contains("id")) {
				xpath = getXpathForTextBoxById(value);
			}
			break;
		case "Link":
			if (type.contains("text")) {
				xpath = getXpathForLinkByText(value);
			} else if (type.contains("id")) {
				xpath = getXpathForLinkById(value);
			}
			break;

		}
		return xpath;
	}
}
