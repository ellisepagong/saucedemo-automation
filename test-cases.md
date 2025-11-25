# Test Cases

## Smoke Tests (@Smoke) 
These are tests concerning the basic essential functions of the website, ensuring that the standard user is able to interact with it outside of any performance failures. 

| Test Code | Test Case         |
|-----------|-------------------|
| SWAG-001  | Successful Log in |
| SWAG-018  | Attempt purchase  |


## Regression Tests (@Regression)
These tests concern the validation of information within the website as well as behavior when unexpected or unauthorized behavior is executed.

| Test Code | Test Case                              |
|-----------|----------------------------------------|
| SWAG-002  | Missing Credentials (Username)         |
| SWAG-002  | Missing Credentials (Password)         |
| SWAG-003  | Incorrect Credentials                  |
| SWAG-004  | Locked out User                        |
| SWAG-005  | Verify Catalog and Product Details     |
| SWAG-006  | Verify Catalog Sort Alphabetically     |
| SWAG-006  | Verify Catalog Sort by Price           |
| SWAG-007  | Missing Information at Checkout        |
| SWAG-009  | Cart Persistence on Log out            |
| SWAG-010  | Verify Price Calculation               |
| SWAG-015  | Verify Error Message on URL Navigation |


## Negative Tests (@Negative)
These are test cases validating broken behavior outside the standard user profile in SauceDemo. <br>

They are included in the regression suite, and use explicit assertions to verify these behaviors.

| Test Code | Test Case                                               |
|-----------|---------------------------------------------------------|
| SWAG-008  | Verify Checkout Proceeds with Empty Cart                |
| SWAG-011  | Verify Images with Problem User                         |
| SWAG-012  | Verify Cart Persistence between accounts                |
| SWAG-013  | Verify sort not working with Problem User               |
| SWAG-014  | Verify missing cart contents with Problem User          |
| SWAG-016  | Verify Checkout Fields not responding with Problem User |
| SWAG-017  | Verify sort not working with Error User                 |
| SWAG-019  | Verify missing cart contents with Error User            |
| SWAG-020  | Verify Checkout Fields not responding with Error User   |
| SWAG-021  | Verify UI Elements incorrect in Visual Error User       |
| SWAG-022  | Verify longer load time in Performance Glitch User      |

