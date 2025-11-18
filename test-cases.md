# Log-in test cases

## Index
| Code numbers | Category                       |
|--------------|--------------------------------|
| 001–004      | Log-in                         |
| 005–010      | Inventory and Checkout Functions |
| 011–012      | Problem User Cases             |
| 013–017      | Invalid Tests                  |


## Smoke Tests (@Smoke) 
| Test Code | Test Case         |
|-----------|-------------------|
| SWAG-001  | Successful Log in |
| SWAG-018  | Attempt purchase  |


## Regression Tests (@Regression)
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
| SWAG-009  | Cart Persistence on Navigation         |
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
| SWAG-015  | Verify Checkout Fields not responding with Problem User |
| SWAG-016  | Verify sort not working with Error User                 |
| SWAG-017  | Verify missing cart contents with Error User            |
| SWAG-018  | Verify Checkout Fields not responding with Error User   |
| SWAG-019  | Verify UI Elements not in Place in Visual Error User    |
| SWAG-020  | Verify longer load time in Performance Glitch User      |

