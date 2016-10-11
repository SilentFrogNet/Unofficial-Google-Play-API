package net.silentfrog.googleplayapi;

/**
 * Created by Ilario Dal Grande <support@silentfrog.net>
 */
public class GooglePlayElement {

	private String mElementName;
	private String mElementPackage;
	private String mElementAuthor;
	private String mElementDetailsUrl;
	private String mElementImgUrl;

	public GooglePlayElement(Builder builder) {
		this.mElementName = builder.elementName;
		this.mElementAuthor = builder.elementAuthor;
		this.mElementPackage = builder.elementPackage;
		this.mElementDetailsUrl = builder.elementDetailsUrl;
		this.mElementImgUrl = builder.elementImgUrl;
	}

	public String getElementName() {
		return mElementName;
	}

	public void setElementName(String mElementName) {
		this.mElementName = mElementName;
	}

	public String getElementPackage() {
		return mElementPackage;
	}

	public void setElementPackage(String mElementPackage) {
		this.mElementPackage = mElementPackage;
	}

	public String getElementDetailsUrl() {
		return mElementDetailsUrl;
	}

	public void setElementDetailsUrl(String mElementDetailsUrl) {
		this.mElementDetailsUrl = mElementDetailsUrl;
	}

	public String getElementImgUrl() {
		return mElementImgUrl;
	}

	public void setElementImgUrl(String mElementImgUrl) {
		this.mElementImgUrl = mElementImgUrl;
	}

	public String getElementAuthor() {
		return mElementAuthor;
	}

	public void setElementAuthor(String mElementAuthor) {
		this.mElementAuthor = mElementAuthor;
	}

	@Override
	public String toString() {
		return "GooglePlayElement{" +
				"Name='" + mElementName + '\'' +
				", Package='" + mElementPackage + '\'' +
				", Author='" + mElementAuthor + '\'' +
				", DetailsUrl='" + mElementDetailsUrl + '\'' +
				", ImgUrl='" + mElementImgUrl + '\'' +
				'}';
	}

	public static class Builder {

		private String elementName;
		private String elementAuthor;
		private String elementPackage;
		private String elementDetailsUrl;
		private String elementImgUrl;

		public Builder elementName(String elementName) {
			this.elementName = elementName;
			return this;
		}

		public Builder elementAuthor(String elementAuthor) {
			this.elementAuthor = elementAuthor;
			return this;
		}

		public Builder elementPackage(String elementPackage) {
			this.elementPackage = elementPackage;
			return this;
		}

		public Builder elementDetailsUrl(String elementDetailsUrl) {
			this.elementDetailsUrl = elementDetailsUrl;
			return this;
		}

		public Builder elementImgageUrl(String elementImgUrl) {
			this.elementImgUrl = elementImgUrl;
			return this;
		}

		public GooglePlayElement build() {
			return new GooglePlayElement(this);
		}

	}

}
