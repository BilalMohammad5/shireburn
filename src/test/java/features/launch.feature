Feature:Indigo user Login
  @smoke @login @tc1
  Scenario Outline: :Launch indigo home page
    Given user launches indigo home page
    Then user should be able to see the website title
    When user enters username as <username> and password as <password>
    And user clicks login
    Then user should be ble to sign in to the indigo application
    Examples:
    |username|password|
    |IntQA11|Kh34685552.|

    @smoke @add @taxProfile
  Scenario Outline: create tax profile
    Given user launches indigo home page
    Then user should be able to see the website title
    When user enters username as <username> and password as <password>
    And user clicks login
    Then user should be ble to sign in to the indigo application
    When user clicks tax profiles tab
    Then user should navigate to tax profiles screen
      When user clicks insert button
      Then user enters new tax profile name <taxProfile> and <description>
      And user clicks save button
      When user clicks usermenu
      And user clicks logout
      Then user should be able to see the website title

    Examples:
      |username|password|taxProfile|description|
      |IntQA11|Kh34685552.|Bilal_test|QA_TEST|



