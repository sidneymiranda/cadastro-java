package taglib;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.TagSupport;

public class CalcAgeTagLib extends TagSupport implements DynamicAttributes {
	private static final long serialVersionUID = -1453150928730520381L;

	private String dob;
	private Integer age = 0;

	public CalcAgeTagLib() {
	}

	public CalcAgeTagLib(String dob) {
		this.dob = dob;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	@Override
	public int doEndTag() throws JspException {
		return super.doEndTag();
	}

	@Override
	public void setDynamicAttribute(String uri, String localName, Object value) throws JspException {
		try {
			localName = dob;
			value = age;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int doStartTag() throws JspException {

		try {
			Calendar today = new GregorianCalendar();
			String dateOfBirth[] = dob.split("/");

			age = today.get(Calendar.YEAR) - Integer.parseInt(dateOfBirth[2]);

			if ((today.get(Calendar.MONTH) + 1 < Integer.parseInt(dateOfBirth[1]))
					|| ((today.get(Calendar.MONTH) + 1 == Integer.parseInt(dateOfBirth[1]))
							&& today.get(Calendar.DAY_OF_MONTH) < Integer.parseInt(dateOfBirth[0]))) {
				age--;
			}

			JspWriter writer = pageContext.getOut();
			writer.println(age + " ano(s)");

		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.doStartTag();
	}

	@Override
	public void release() {
		super.release();
	}

}
