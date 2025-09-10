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
| Test Code | Test Case                                      |
|-----------|------------------------------------------------|
| SWAG-002  | Missing Credentials (Username)                 |
| SWAG-002  | Missing Credentials (Password)                 |
| SWAG-003  | Incorrect Credentials                          |
| SWAG-004  | Locked out User                                |
| SWAG-005  | Verify Catalog and Product Details             |
| SWAG-006  | Verify Catalog Sort Alphabetically             |
| SWAG-006  | Verify Catalog Sort by Price                   |
| SWAG-007  | Missing Information at Checkout                |
| SWAG-009  | Cart Persistence on Navigation                 |
| SWAG-009  | Cart Persistence on Log out                    |
| SWAG-010  | Verify Price Calculation                       |
| SWAG-011  | Verify Images while Problem user logged in     |
| SWAG-012  | Attempt purchase while Problem user logged in  |


## Invalid Tests (@Fail)
These are known cases in SauceDemo where expected does not match actual behavior, and expected to fail. <br>

They are excluded from Smoke and Regression suites to prevent check failure on pull request, and are run through the manual workflow instead.

| Test Code | Test Case                                     |
|-----------|-----------------------------------------------|
| SWAG-008  | Attempt Checkout with empty cart              |
| SWAG-013  | Attempt purchase with Performance Glitch User |
| SWAG-014  | Whitespace in checkout fields                 |
| SWAG-015  | Inventory URL Navigation                      |
| SWAG-016  | Checkout URL Navigation                       |
| SWAG-017  | Cart Persistence between accounts             |
