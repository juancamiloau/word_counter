Feature: Count words
  As a Grammatical User
  I want to know how many words and chars haves a string


  Scenario: Count string
    Given "Juan" is on wordcounter
    When he enters a random paragraphs
    Then he should see the number of words
    And he should see the number of characters
    And he should see the text with number of words and characters


  Scenario: Count string after clean
    Given "Juan" is on wordcounter
    When he enters a random paragraphs and clean field
    Then he should see the number of words
    And he should see the number of characters
    And he should see the text with number of words and characters


  Scenario: Most repetition words
    Given "Juan" is on wordcounter
    When he enters repeated random words
    Then he should see the number of words
    And he should see the number of characters
    And he should see the text with number of words and characters
    And he should see the most repeated words