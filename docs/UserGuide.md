---
layout: page
title: User Guide
---

<img src="images/tCheckLogo.png" width="200" height="200" />

Welcome to the tCheck User Guide! Thank you for choosing tCheck, the most popular command-line milk tea shop management desktop application in the T-Sugar chain!

tCheck offers an integrated system to efficiently manage a T-Sugar shop, by providing sales tracking, ingredient tracking and employees' contact management in one platform.

This guide will help you to get started with tCheck, and provide useful tips along the way.



* Table of Contents
    * [About this document](#about-this-document)
    * [Quick start](#quick-start)
    * [Features](#features)
        * [Commands - General](#commands-general)
        * [Commands - Sales Tracking](#commands-sales-tracking) 
        * [Commands - Ingredients Tracking](#commands-ingredients-tracking)
        * [Commands - Contact details](#commands-contact-details)
    * [Command summary](#command-summary)

--------------------------------------------------------------------------------------------------------------------
## About this document  <a name="about-this-document"></a>
This document introduces the features of tCheck. 

The following are symbols and formatting used in this document:

:bulb: 
Tips are used to describe small features or techniques
that may come in handy when using tCheck!


:information_source: 
Notes describe certain features or behaviour that may
not be so obvious!

--------------------------------------------------------------------------------------------------------------------

## Quick start `[Release coming soon]` <a name="quick-start"></a>

1. Ensure you have Java `11` or above installed in your Computer.

1. Download the latest `tCheck.jar` from [here](https://github.com/AY2021S1-CS2103T-T12-2/tp/releases).

1. Copy the file to the folder you want to use as the _home folder_ for your tCheck.

1. Double-click the file to start the app. The GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)

1. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

   * **`list`** : Lists all contacts.

   * **`add`**`n/John Doe p/98765432 e/81234567 t/part time` : Adds an employee's contact
    named `John Doe` to tCheck.

   * **`delete`**`3` : Deletes the 3rd contact shown in the current list.

   * **`clear`** : Deletes all contacts.

   * **`exit`** : Exits the app.

1. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Features <a name="features"></a>

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `ingredient NAME`, `NAME` is a parameter which can be used as `ingredient milk`.

* Items in square brackets are optional.<br>
  e.g `n/NAME [t/TAG]` can be used as `n/John Doe t/friend` or as `n/John Doe`.

* Items with `…`​ after them can be used once or multiple times.<br>
  e.g. `sales A/NUM B/NUM C/NUM …` can be used as `sales BSBM/100` or `sales BSBM/100 BSBBT/120`.


* Parameters can be in any order.<br>
  e.g. if the command specifies `n/NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER n/NAME` is also acceptable.

</div>

### 1. Commands - General <a name="commands-general"></a>
#### 1.1 Viewing help : `help`

Displays a brief explanation of the list of commands, and a link to the help page, which is the user guide.

Format: `help`

#### 1.2 Exiting the program : `exit`

Exits the program.

Format: `exit`

#### 1.3 Saving the data :

All tCheck data (i.e. contact details, ingredient data, sales data) are saved in the hard disk automatically after any
 command that changes the data. There is no need to save manually.


### 2. Commands - Sales Tracking <a name="commands-sales-tracking"></a>

<div markdown="span" class="alert alert-primary">

**:information_source: Notes about available drinks:**<br>

Currently, there are 6 types of drinks that can be tracked by tCheck's sales tracker. The drinks and their respective
 abbreviations are shown as below:<br>
 
* `BSBM`  : Brown Sugar Boba Milk<br>

* `BSBBT` : Brown Sugar Boba Black Tea<br>

* `BSBGT` : Brown Sugar Boba Green Tea<br>

* `BSPM`  : Brown Sugar Pearl Milk<br>

* `BSPBT` : Brown Sugar Pearl Black Tea<br>

* `BSPGT` : Brown Sugar Pearl Green Tea<br>

</div>

#### 2.1 Updating the number of drinks sold for the day : `s-update`
Updates tCheck on the number of each type of drink sold for the current day, based on the sales data provided by the
user.

Format: `s-update A/NUM B/NUM C/NUM ...`
* `A`, `B`, `C` are abbreviations for the drink types.
* `NUM` refers to the number of drinks sold. It should be a non-negative integer.

Example:
* `s-update BSBM/100 BSBBT/120` Updates the sales of Brown Sugar Boba Milk `BSBM` to 100 and
 Brown Sugar Boba Black Tea `BSBBT` to 120.

#### 2.2 Listing the number of drinks sold for the day : `s-list`
Shows a list of all types of drinks sold for the current day.

Format: `s-list`

#### 2.3 Listing the sales record for a specific day :
Shows a sales record for each type of mile tea on a specific date.

Format: `sales YYYY-MM-DD`
* `YYYY-MM-DD` refers to date in YYYY-MM-DD format.

Example:
* `sales 2020-08-01` returns the sales record for each type of milk tea on 2020-08-01.
 
 
### 3. Commands - Ingredients Tracking <a name="commands-ingredients-tracking"></a>

    
<div markdown="span" class="alert alert-primary">

**:information_source: Notes about ingredients:**<br>

* Unit of measurement for ingredients:<br>
    * - Unit for solid items / jelly (Pearl, Boba and Brown Sugar) : **KG**<br>
    * - Unit for liquids (Milk and Oolong Tea) : **L**<br>

* All ingredients' levels are set to 0.<br>

* All ingredients which are available and thus can be set are predefined in the ingredient book.<br>
  
* Please note that the ingredient names are case-sensitive.<br>

* Here is a comprehensive list of all available ingredients :<br>
    * - Milk<br>
    * - Pearl<br>
    * - Boba<br>
    * - Oolong Tea<br>
    * - Brown Sugar<br>

</div>

#### 3.1 Setting one ingredient's level : `i-set`

Sets the level of one single ingredient predefined in the ingredient book to the specified amount.

Format: `i-set i/INGREDIENT_NAME m/AMOUNT`

* Sets the `INGREDIENT_NAME` to the specified `AMOUNT`.

Example:
* `i-set i/Milk m/15`


#### 3.2 Setting all ingredients' levels to different specified amounts : `i-set-all`

Sets all ingredients' levels to different specified amounts according to user inputs.

Format: `i-set-all M/AMOUNT_FOR_MILK P/AMOUNT_FOR_PEARL B/AMOUNT_FOR_BOBA O/AMOUNT_FOR_OOLONG_TEA S/AMOUNT_FOR_SUGAR`

* Sets all ingredients' levels as such : Milk : `AMOUNT_FOR_MILK` L, Pearl : `AMOUNT_FOR_PREAL` KG, Boba : `AMOUNT_FOR_BOBA` KG, Oolong Tea : `AMOUNT_FOR_OOLONG_TEA` L, Brown Sugar : `AMOUNT_FOR_BROWN_SUGAR` KG.

Example:
* `i-set-all M/20 P/20 B/20 O/50 S/50`

#### 3.3 Setting all ingredients to different levels : `i-set-default`

Sets all ingredients' levels to their pre-determined default levels for a stall.

Format: `i-set-default`

* Sets all ingredients' levels to their default levels : Milk : 50 L, Pearl : 20 KG, Boba : 20 KG, Oolong Tea : 50 L, Brown Sugar : 20 KG.

Example:
* `i-set-default`

#### 3.4 Viewing a single ingredient's level : `i-view-single`
Shows the ingredient's level of a particular type of ingredient which is specified by the user’s command.

Format: `i-view-single i/INGREDIENT_NAME`

Example:
* `i-view-single i/Milk`
Shows the amount of milk which is recorded by tCheck.

#### 3.5 Resetting all ingredients' levels to zero : `i-reset-all`
Sets all ingredients' levels to zero.

Format: `i-reset-all`

#### 3.6 Listing all ingredients' levels : `i-list`
Shows the ingredient's levels of all ingredient types.

Format: `i-list`

### 4. Commands - Contact details <a name="commands-contact-details"></a>

#### 4.1 Adding an employee : `c-add`

Adds an employee to the contact list.

Format: `c-add n/NAME p/PHONE_NUMBER e/EMERGENCY_CONTACT [t/TAG]…​`

<div markdown="span" class="alert alert-primary">:bulb: 

**Tip:**
An employee can have any number of tags (including 0)
</div>

Examples:
* `c-add n/John Doe p/98765432 e/81234567`.
* `c-add n/Betsy Crowe e/81234567 p/1234567 t/morning shift t/part-time`.

#### 4.2 Listing all employees : `c-list`

Shows a list of all employees in the contact list.


Format: `c-list`
  
#### 4.3 Editing a person : `c-edit`

Edits the corresponding contact information in the contact list.

Format: `c-edit INDEX n/NAME p/PHONE e/EMERGENCY_CONTACT [t/TAG] …​​`

* Edits the employee at the specified `INDEX`. The index refers to the index number shown in the displayed contact list. The index **must be a positive integer** 1, 2, 3, …​
* At least one of the optional fields must be provided.
* Existing values will be updated to the input values.
* When editing tags, the existing tags of the employee will be removed i.e adding of tags is not cumulative.
* You can remove all the employees’s tags by typing `t/` without
    specifying any tags after it.

Examples:
*  `c-edit 1 p/91234567 e/81234567` Edits the phone number and emergency contact of the 1st employee to be `91234567` and
 `81234567` respectively.
*  `c-edit 2 n/Betsy Crower t/` Edits the name of the 2nd employee to be `Betsy Crower` and clears all existing tags.


#### 4.4 Locating persons by keywords: `c-find`

Finds all contacts that contain the KEYWORD(s).

Format: `c-find KEYWORD [MORE_KEYWORDS]`

* The search is case-insensitive. e.g `hans` will match `Hans`.
* The order of the keywords does not matter. e.g. `Hans Bo` will match `Bo Hans`.
* Only the name is searched.
* Only full words will be matched e.g. `Han` will not match `Hans`.
* Employees matching at least one keyword will be returned (i.e. `OR` search).
  e.g. `Hans Bo` will return `Hans Gruber`, `Bo Yang`.

Examples:
* `c-find John` returns `john` and `John Doe`.
* `c-find alex david` returns `Alex Yeoh`, `David Li`.<br>

#### 4.5 Deleting a person : `c-delete`

Deletes the specified employee from the contact list.

Format: `c-delete INDEX`

* Deletes the person at the specified `INDEX`.
* The index refers to the index number shown in the displayed person list.
* The index **must be a positive integer** 1, 2, 3, …​

Examples:
* `c-list` followed by `c-delete 2` deletes the 2nd employee in the contact list.
* `c-find Betsy` followed by `c-delete 1` deletes the 1st employee in the results of the `c-find` command.

#### 4.6 Clearing all entries : `c-clear`

Clears all entries from the contact list.

Format: `c-clear`

#### 4.7 Archiving an employee : `c-archive`
Archives the specified employee's contact detail from the tCheck.

Format: `c-archive INDEX`

* Archives the employee at the specified `INDEX`.
* The index refers to the index number shown in the displayed `employees' contact details` panel.
* The index **must be a positive integer** 1, 2, 3, …​

<div markdown="span" class="alert alert-primary">:bulb: 

**Tip:**
Command `c-list` can be used first to show a list of all active employees' contact details. 
Then, `c-archive INDEX` can be used to archive a specific employee.
</div>

Examples:
* `c-list` followed by `c-archive 2` archives the 2nd person in the employees' contact details.
* `c-find Betsy` followed by `c-archive 1` archives the 1st person in the results of the `find` command.

#### 4.8 Archiving all employees : `c-archive all`
Archives all employees' contact details from the tCheck.

Format: `c-archive all`

#### 4.9 Listing all archived employees : `c-archive list`
Shows a list of all archived employees' contact details in tCheck.

Format: `c-archive list`

#### 4.10 Unarchiving an employee : `c-unarchive`
Unarchives the specified employee's contact detail from the tCheck's archived employee list.

Format: `c-unarchive INDEX`

* Unarchives the employee at the specified `INDEX`.
* The index refers to the index number shown in the displayed `employees' contact details` panel.
* The index **must be a positive integer** 1, 2, 3, …​

<div markdown="span" class="alert alert-primary">:bulb: 

**Tip:**
Command `c-archive-list` can be used first to show a list of all archived employees' contact details. 
Then, `c-unarchive INDEX` can be used to unarchive a specific employee.
</div>

Examples:
* `c-archive-list` followed by `c-unarchive 2` unarchives the 2nd person in the archived employees' contact details.


## Command summary <a name="command-summary"></a>

### General

Action | Format, Examples
-------|------------------------------
**Help** | `help`
**Exit** | `exit`

### Sales Tracking

Action | Format, Examples
-------|------------------------------
**Update**| `s-update A/NUM B/NUM C/NUM ...` <br> e.g., `s-update BSBM/100 BSBBT/120`
**List**| `s-list`
**Find**| `sales YYYY-MM-DD`

### Ingredients  Tracking

Action | Format, Examples
-------|------------------------------
**Set a single ingredient**  | `i-set i/INGREDIENT_NAME m/AMOUNT` <br> e.g., `i-set i/Milk m/20`
**Set all ingredients**  | `i-set-all M/AMOUNT_FOR_MILK P/AMOUNT_FOR_PEARL B/AMOUNT_FOR_BOBA O/AMOUNT_FOR_OOLONG_TEA S/AMOUNT_FOR_SUGAR` <br> e.g., `i-set-all M/20 P/20 B/20 O/50 S/100`
**Set all ingredients to default**  | `i-set-default` <br> e.g., `i-set-default`
**View a single ingredient**| `i-view-single INGREDIENT_NAME`  <br> e.g., `i-view-single i/Milk`
**Reset**| `i-reset-all`
**List**| `i-list`

### Employees' Contact Details

Action | Format, Examples
-------|------------------------------
**Add** | `c-add n/NAME p/PHONE_NUMBER e/EMERGENCY_CONTACT [t/TAG]…` <br> e.g., `c-add n/James Ho p/22224444 e/81234567 t/morning shift`
**List** | `c-list`
**Edit** | `c-edit INDEX [n/NAME] [e/EMERGENCY_CONTACT] [t/TAG]…​`<br> e.g.,`c-edit 2 n/James Lee e/81234567`
**Find** | `c-find KEYWORD [MORE_KEYWORDS]`<br> e.g., `c-find James Jake`
**Delete** | `c-delete INDEX`<br> e.g., `c-delete 3`
**Clear** | `c-clear`
**Archive** |  1. **Archive \(1 employee\):**  `c-archive INDEX`<br> e.g., `c-archive 1` <br>2. **Archive \(all employees\):**  `c-archive all` <br>3. **List all archived data:**  `c-archive list`</br>
**Unarchive** | `c-unarchive INDEX`<br> e.g., `c-unarchive 1` 

 
