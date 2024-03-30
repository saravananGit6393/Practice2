package com.eaias.pageobjectmanager;

import com.eaias.pages.CuEAIASContactUsPage;

public class PageObjectManager {
	
	private CuEAIASContactUsPage cuEAIASContactUsPage;

	public CuEAIASContactUsPage getCuEAIASContactUsPage() {
		return (cuEAIASContactUsPage==null)? cuEAIASContactUsPage = new CuEAIASContactUsPage():cuEAIASContactUsPage;
	}
	
	

}
