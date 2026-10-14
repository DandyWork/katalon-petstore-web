# katalon-petstore-web: JPetStore Web UI Automation (Katalon Studio)

Automated web UI tests for the JPetStore demo site, built with **Katalon Studio (Free)**.

- **Application under test:** https://petstore.octoperf.com/actions/Catalog.action
- **Tool:** Katalon Studio (Free), Groovy, Chrome
- **Approach:** Object Repository with clear names, reusable custom keywords, data-driven testing (DDT) for login

## Project Structure

| Folder | Content |
|---|---|
| `Test Cases` | `valid_Login`, `add_Cart`, `purchase_Cart`, `Logout` |
| `Test Suites` | `TS_Login_DDT`, `TS_Purchase` |
| `Data Files` | `TD_Login` (internal test data for login DDT) |
| `Object Repository` | Test objects grouped by page: `Catalog`, `SignIn`, `Fish`, `ShopingCart`, `Checkout`, `OderConfirm`, `OrderSuccess`, `Header` |
| `Keywords` | `common.LoginKeywords.groovy` (reusable login), `common.ChromeClean.groovy` (opens Chrome without the leaked-password popup) |
| `Profiles` | `default` profile with global variables |
| `Reports` | Generated after each test suite run |

## How to Run

### Prerequisites
- Katalon Studio (Free) installed
- Google Chrome installed
- Internet access to petstore.octoperf.com

### Setup
1. Open Katalon Studio and choose **File → Open Project**, then select this project folder.
2. Open **Profiles → default** and check the global variables:

   | Variable | Description | Example |
   |---|---|---|
   | `G_BaseUrl` | Base URL of the site | `'https://petstore.octoperf.com'` |
   | `G_Username` | Login username (demo account) | `'j2ee'` |
   | `G_Password` | Login password (set as **Protected**) | `'j2ee'` |

3. Make sure `G_Password` holds the plain password. The tests use `setText`, not `setEncryptedText`.

### Run
1. Open **Test Suites → TS_Login_DDT** (login) or **TS_Purchase** (add to cart and purchase).
2. Click the **Run** button (Chrome).
3. `TS_Login_DDT` runs once per row in `TD_Login`. `TS_Purchase` runs `add_Cart`, then `purchase_Cart`.

To run a single test case (for example `purchase_Cart`), open it and use the **Run** button. `purchase_Cart` calls `add_Cart`, which opens the browser, logs in and adds the item to the cart. `purchase_Cart` then continues with checkout and closes the browser at the end.

### Report
After a run, open the **Reports** folder in Tests Explorer, or the **Result** tab, to see pass/fail per iteration. To choose the export format (HTML, CSV, PDF), go to **Project → Settings → Plugins → Report**.

## Test Suites

| Test Suite | Test Case | Test Data | Description |
|---|---|---|---|
| `TS_Login_DDT` | `valid_Login` | `TD_Login` (iteration: All) | Runs the login flow once for each data row |
| `TS_Purchase` | `add_Cart`, `purchase_Cart` | None | Runs the add to cart flow, then the full purchase flow: cart, checkout, order confirmation and order success |

### Test data (`TD_Login`)

| username | password | expected | Scenario |
|---|---|---|---|
| j2ee | j2ee | success | Valid login |
| j2ee | wrongpass | invalid | Wrong password |
| wronguser | j2ee | invalid | Wrong username |
| (empty) | (empty) | empty | Empty credentials |

Variables in the suite are bound as **Data Column**: `username`, `password`, `expected`.

## Test Coverage

| Area | Test Case | Covered scenarios |
|---|---|---|
| Login | `valid_Login` (DDT) | Valid login shows the welcome message; wrong password and wrong username show an error message and do not log in; empty credentials reload the Sign In page without a message and do not log in |
| Add to cart | `add_Cart` | Login, open Fish category, open product, open item, add to cart, verify Item ID and Product ID in the shopping cart, return to home |
| Purchase | `purchase_Cart` | Run `add_Cart`, open shopping cart, verify the cart page (title, Item ID, Product ID), proceed to checkout, verify Payment Details and Billing Address, continue, verify order confirmation (message, billing and shipping address), confirm, verify order success (thank you message, addresses, order date is today), return to main menu, verify the welcome text, close the browser |
| Logout | `Logout` | Login with the keyword, click Sign Out, verify the Sign In button is shown again, close the browser |

### Not covered
- Registration of a new account
- Search, remove from cart, update cart quantity
- Other browsers (tests run on Chrome only)

## Notes
- Some test objects use dynamic XPath with `${...}` placeholders (for example item ID and product ID) and are filled from global variables when the test runs.
- `ChromeClean` opens Chrome in incognito mode with the password manager and leak detection turned off, because Chrome warns that the demo password `j2ee` appears in known data breaches.
- `add_Cart` opens the browser with `ChromeClean` and does not close it, so that `purchase_Cart` can continue in the same browser and close it at the end. If you run `add_Cart` on its own, close Chrome manually afterwards.
