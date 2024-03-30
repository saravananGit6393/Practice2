@ContactUsFeature
Feature: Verifying EAIAS Website ContactUs Module Automation

  @Scenario1
  Scenario Outline: Verifying the contactus page is working or not
    Given User is on the facebook Homepage
    When User click contact us link
    And User enters given field "<title>", "<name>", "<companyName>", "<jobtitle>", "<location>" and "<mobNo>"
    Then User should verify success message after enters contact us page "Contact Us"
    And User should verify success message or failed message after click send button "Contact us column is working fine" and "Contact us coloumn is not working"
    Examples: 
      | title | name | companyName | jobtitle | location | mobNo      |
      | Mr    | ABC  | IASEAS      | Tester   | India    | 9876543210 |
