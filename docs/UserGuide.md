---
layout: page
title: User Guide
---
* Table of Contents
    * [Introduction](#introduction)
    * [Quick start](#quick-start)
    * [About this document](#about-this-document)
    * [Features](#features)
        * [Commands - Sales Tracking](#commands-sales-tracking) 
        * [Commands - Ingredients Tracking](#commands-ingredients-tracking)
        * [Commands - Contact details](#commands-contact-details)
        * [Commands - General](#commands-general)
    * [FAQ](#FAQ)
    * [Command summary](#command-summary)

## Introduction <a name="introduction"></a>
<img src="images/tCheckLogo.png" width="200" height="200" />

Welcome to the User Guide of **tCheck**!
 
Are you a bubble tea store manager (from T-Sugar) looking to reduce your time spent on administrative work in store
management? Look no further, as tCheck can assist you with these tasks.

tCheck is a desktop application that offers an integrated system to efficiently manage a bubble tea shop, of 
the (imaginary) brand T-sugar, by providing sales tracking, ingredient tracking and manpower management. It is an
application optimized for the Command Line Interface (CLI); this means that you use this application by typing
commands into a _Command Box_. If you are a fast typist, then you will be able to update and retrieve the
information in tCheck more efficiently, as opposed to using other applications that requires a mouse.

This User Guide will help you get started with tCheck and learn how to use the features that tCheck provides.
You can start from the [Quick Start](#quick-start) section to learn how to obtain tCheck to begin managing
 your store more efficiently.

--------------------------------------------------------------------------------------------------------------------
## Quick start <a name="quick-start"></a>

1. Ensure you have Java `11` or above installed in your Computer.

1. Download the latest `tCheck.jar` from [here](https://github.com/AY2021S1-CS2103T-T12-2/tp/releases).

1. Copy the file to the folder you want to use as the _home folder_ for your tCheck.

1. Double-click the file to start the app. The GUI similar to the below should appear in a few seconds. Note
how the figure below shows some sample data.<br>
   ![Ui](images/Ui.png)

1. Type the command in the command box and press "Enter" on your keyboard to execute it. e.g. typing **`help`** and pressing "Enter" will open the help window.<br>
   Some example commands you can try:

   * **`c-add`**`n/John Doe p/98765432 e/81234567 a/Blk 123 Brooklin Street t/parttime` : Adds an employee
    named `John Doe` to tCheck.

   * **`c-delete`**`3` : Deletes the 3rd employee shown in the current list of employees.

   * **`c-clear`** : Deletes all employees.

   * **`exit`** : Exits the app.

1. Refer to the [Features](#features) below for details of each command.

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

## Features <a name="features"></a>

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `ingredient NAME`, `NAME` is a parameter which can be used as `ingredient milk`.

* Items in square brackets are optional.<br>
  e.g `n/NAME [t/TAG]` can be used as `n/John Doe t/friend` or as `n/John Doe`.

* Items with `...`​ after them can be used once or multiple times.<br>
  e.g. `sales A/NUM B/NUM C/NUM ...` can be used as `sales BSBM/100` or `sales BSBM/100 BSBBT/120`.


* Parameters can be in any order.<br>
  e.g. if the command specifies `n/NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER n/NAME` is also acceptable.

</div>

### 1. Commands - Sales Tracking <a name="commands-sales-tracking"></a>

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


#### 1.1 Updating the number of drinks sold : `s-update`
Updates the number of drinks sold for each drink type as given in the user input.


Format: `s-update A/NUM B/NUM C/NUM ...`
* `A`, `B`, `C` are abbreviations for the drink types.
* `NUM` refers to the number of drinks sold. It should be a non-negative integer.

Example:
* `s-update BSBM/100 BSBBT/120` Updates the sales of Brown Sugar Boba Milk `BSBM` to 100 and
 Brown Sugar Boba Black Tea `BSBBT` to 120.
 
 <div markdown="span" class="alert alert-primary">
 
:information_source: Note about the update: <br>

The record in tCheck will be overwritten by the input that you provide. <br>
 
 </div>

#### 1.2 Listing the number of drinks sold : `s-list`
Shows a list of all types of drinks sold in the Sales Tracker.

Format: `s-list`

#### 1.3 Finds the number of drinks by keywords : `s-find`

Finds all drinks where their abbreviated names match the KEYWORD(s).

Format: `s-find KEYWORD [MORE_KEYWORDS] ...`

* The search is case-insensitive. e.g `bsbbt` will match `BSBBT`.
* Only the drink's abbreviated name is searched.
* Only full words will be matched e.g. `BSB` will not match `BSBBT`.
* Drinks matching at least one keyword will be returned.
  e.g. `BSBBT BSBM` will return `BSBBT`, `BSBM`.

Examples:
* `s-find BSBBT` returns `BSBBT`'s sales data.
* `s-find BSBBT BSBM` returns `BSBBT`'s sales data and `BSBM`'s sales data.<br>
 
#### 1.4 Ranking the list of drinks sold : `s-rank`
Shows a ranked list of all types of drinks sold in the Sales Tracker. The list of drinks
is ranked from the most popular to least popular.
  
Format: `s-rank`

 
### 2. Commands - Ingredients Tracking <a name="commands-ingredients-tracking"></a>

    
<div markdown="span" class="alert alert-primary">

**:information_source: Notes about ingredients:**<br>

* Unit of measurement for ingredients:<br>
    * - Unit for solid items / jelly (Pearl, Boba and Brown Sugar) : **KG**<br>
    * - Unit for liquids (Milk, Black Tea and Green Tea) : **L**<br>

* All ingredients' levels are set to 0.<br>

* All ingredients which are available and thus can be set are predefined in the ingredient book.<br>
  
* Please note that the ingredient names are case-sensitive.<br>

* Here is a comprehensive list of all available ingredients :<br>
    * - Milk<br>
    * - Pearl<br>
    * - Boba<br>
    * - Black Tea<br>
    * - Green Tea<br>
    * - Brown Sugar<br>

</div>

#### 2.1 Setting one ingredient's level : `i-set`

Sets the level of one single ingredient predefined in the ingredient book to the specified amount.

Format: `i-set i/INGREDIENT_NAME m/AMOUNT`

* Sets the `INGREDIENT_NAME` to the specified `AMOUNT`.

Example:
* `i-set i/Milk m/15`


#### 2.2 Setting all ingredients' levels to different specified amounts : `i-set-all`

Sets all ingredients' levels to different specified amounts according to user inputs.

Format: `i-set-all M/AMOUNT_FOR_MILK P/AMOUNT_FOR_PEARL B/AMOUNT_FOR_BOBA L/AMOUNT_FOR_BLACK_TEA G/AMOUNT_FOR_GREEN_TEA S/AMOUNT_FOR_BROWN_SUGAR`

* Sets all ingredients' levels as such : Milk : `AMOUNT_FOR_MILK` L, Pearl : `AMOUNT_FOR_PEARL` KG, Boba : `AMOUNT_FOR_BOBA` KG, Black Tea : `AMOUNT_FOR_BLACK_TEA` L, Green Tea: `AMOUNT_FOR_GREEN_TEA`, Brown Sugar : `AMOUNT_FOR_BROWN_SUGAR` KG.

Example:
* `i-set-all M/20 P/20 B/20 L/50 G/80 S/50`

#### 2.3 Setting all ingredients to different levels : `i-set-default`

Sets all ingredients' levels to their pre-determined default levels for a stall.

Format: `i-set-default`

* Sets all ingredients' levels to their default levels : Milk : 50 L, Pearl : 20 KG, Boba : 20 KG, Black Tea : 50 L, Green Tea : 50 L, Brown Sugar : 20 KG.

Example:
* `i-set-default`

#### 2.4 Listing all ingredients' levels : `i-list`
Lists the ingredient's levels of all ingredient types.

Format: `i-list`

Example:
Let's say you want to list all the ingredients. 
You can follow these instructions.

1. Type `i-list` into the _Command Box_.
1. Press "Enter" on your keyboard to execute the command.

Outcome:
1. The _Result Display_ will show a success message.
2. The Ingredient Tracker inside the _Main View_ will show the list of ingredients.

{Example outcome screenshot to be added later}

#### 2.5 Finding ingredients by keywords : `i-find`
Finds all ingredients that contain the KEYWORD(s) in their names.

Format: `i-find KEYWORD [MORE_KEYWORDS]`

* The search is case-insensitive. For example, `milk` will match `Milk`.<br>
* The order of the keywords does not matter. For example, `Milk Boba` will match `Boba Milk`.<br>
* Only the ingredient names are searched.<br>
* Only full words will be matched. For example, `Mil` will not match `Milk`.<br>
* Ingredients with names matching at least one keyword will be listed in the Ingredient Tracker inside the _Main View_ 
(i.e. `OR` search). For example, `i-find Milk Boba` will find the ingredient `Milk` and the ingredient `Boba`.<br>

Example: Let's say you want to find the ingredients that have names containing the keyword `Tea`.
You can follow these instructions:

1. Type `i-find Tea Sugar` into the _Command Box_.
2. Press "Enter" to execute the command.

Outcome:

1. The _Result Display_ will show a success message.
2. The Ingredient Tracker inside the _Main View_ will show the ingredient `Black Tea`, the ingredient `Green Tea` and 
the ingredient `Brown Sugar`.

{Example outcome screenshot to be added later}

#### 2.6 Resetting all ingredients' levels to zero : `i-reset-all`
Resets all types of ingredients' levels to zero in tCheck.

Format: `i-reset-all`

Example: Let's say you want to reset all ingredients' levels to zero, and the ingredient's levels are not currently all at zero.
You can follow these instructions:

1. Type ` i-reset-all` into the _Command Box_.
2. Press "Enter" to execute the command.

Outcome:

1. The _Result Display_ will show a success message.
2. You can now see that tCheck has updated all the ingredients' levels to zero in the Ingredient Tracker inside the _Main View_.

![IngredientResetAllCommandScreenshot](images/IngredientResetAllCommandScreenshot.png)

Figure x. A screenshot showing the outcome of an `i-resert-all` command

#### 2.7 Listing all ingredients that user should restock : `i-restock`
Lists the ingredient's levels of all ingredient types that fall below their pre-determined default levels and require the user to 
restock. The list also includes the amount needed for each ingredient to reach its pre-determined default level.

Format: `i-restock`

<div markdown="block" class="alert alert-info">

**:information_source: Notes:**<br>
Refer to the "Notes about ingredients" below the [Commands - Ingredients Tracking](#commands-ingredients-tracking)
for details on the pre-determined default levels of different types of ingredients.
</div>

Example: Let's say you want to find out which ingredients you need to restock.
You can follow these instructions:

1. Type ` i-restock` into the _Command Box_.
2. Press `"Enter" to execute the command.

Outcome:

1. The _Result Display_ will show a list of ingredients that the user should restock, including each ingredient's name, 
its ingredient's level and the amount needed for the ingredient to reach its pre-determined default level.

![IngredientRestockCommandScreenshot](images/IngredientRestockCommandScreenshot.png)

Figure x. A screenshot showing the outcome of an `i-restock` command

<div markdown="block" class="alert alert-info">

**:information_source: Notes:**<br>
Due to the limited ize of the _Result Display_, only a part of the list of ingredients that the user should restock
is shown in the screenshot above. In the actual application, you can scroll down to see the entire list.
</div>

### 3. Commands - Contact details <a name="commands-contact-details"></a>

#### 3.1 Adding an employee : `c-add`

Adds an employee to the contact list.

Format: `c-add n/NAME p/PHONE_NUMBER e/EMERGENCY_CONTACT a/ADDRESS [t/TAG] ...`

<div markdown="span" class="alert alert-primary">:bulb: 

**Tip:**
An employee can have any number of tags (including 0)
</div>

Examples:
* `c-add n/John Doe p/98765432 e/81234567 a/Blk 123 ABC Road`.
* `c-add n/Betsy Crowe e/81234567 p/89007413 a/Blk 120 ABC Road t/Friday t/PartTime`.

#### 3.2 Listing all employees : `c-list`

Shows a list of all employees in the contact list.


Format: `c-list`

#### 3.3 Listing all employees who are working today: `c-today`

Shows a list of all active(unarchived) employees whose tags contain today's day (i.e. `Wednesday`, `Tuesday`, etc).

Format: `c-today`

* The search is case-insensitive. e.g `Friday` will match `friday`.

Examples:
* Assume today is `Wednesday`, after command `c-today`, all employees whose tags contain `Wednesday` will be
  listed out. 

#### 3.4 Listing all employees who are working tomorrow: `c-tomorrow`

Shows a list of all active(unarchived) employees whose tags contain tomorrow's day (i.e. `Wednesday`, `Tuesday`, etc).

Format: `c-tomorrow`

* The search is case-insensitive. e.g `Friday` will match `friday`.

Examples:
* Assume today were `Wednesday`, tomorrow would be `Thursday`, after command `c-tomorrow`, all employees whose
tags contain `Thursday` will be listed out. 
  
#### 3.5 Editing a person : `c-edit`


Edits the corresponding contact information in the contact list.

Format: `c-edit INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMERGENCY_CONTACT] [a/ADDRESS] [t/TAG] ...`

* Edits the employee at the specified `INDEX`. The index refers to the index number shown in the displayed contact list. The index **must be a positive integer** 1, 2, 3, ...​
* At least one of the optional fields must be provided.
* Existing values will be updated to the input values.
* When editing tags, the existing tags of the employee will be removed i.e adding of tags is not cumulative.
* You can remove all the employees’s tags by typing `t/` without
    specifying any tags after it.

Examples:
*  `c-edit 1 p/91234567 e/81234567` Edits the phone number and emergency contact of the 1st employee to be `91234567` and
 `81234567` respectively.
*  `c-edit 2 n/Betsy Crower t/` Edits the name of the 2nd employee to be `Betsy Crower` and clears all existing tags.


#### 3.6 Locating persons by keywords: `c-find`

Finds all active(unarchived) contacts that contain the KEYWORD(s) in their names.

Format: `c-find KEYWORD [MORE_KEYWORDS] ...`

* The search is case-insensitive. e.g `hans` will match `Hans`.
* The order of the keywords does not matter. e.g. `Hans Bo` will match `Bo Hans`.
* Only the name is searched.
* Only full words will be matched e.g. `Han` will not match `Hans`.
* Employees matching at least one keyword will be returned (i.e. `OR` search).
  e.g. `Hans Bo` will return `Hans Gruber`, `Bo Yang`.

Examples:
* `c-find John` returns `john` and `John Doe`.
* `c-find alex david` returns `Alex Yeoh`, `David Li`.<br>

#### 3.7 Locating persons based on matching tags: `c-tag-find`

Finds all active(unarchived) contacts that contain the KEYWORD(s) in their tags.

Format: `c-tag-find KEYWORD [MORE_KEYWORDS] ...`

* The search is case-insensitive. e.g `Friday` will match `friday`.
* The order of the keywords does not matter. e.g. `friday monday` will match `monday friday`.
* Only the tag names are searched.
* Only full words will be matched e.g. `PartTime` will not match `PartTimes`.
* Employees whose tag(s) matching at least one keyword will be listed in the `Employee Contact DeatailL` pane
 (i.e. `OR` search).  e.g. `Friday Monday` will return employees whose tags contain `Friday` or `Monday`.

Examples:
* `c-tag-find friday` returns all employees whose tags contain `friday`.
* `c-tag-find friday parttime` returns all employees whose tags contain `friday`, `parttime`.<br>

#### 3.8 Deleting a person : `c-delete`

Deletes the specified employee from the contact list.

Format: `c-delete INDEX`

* Deletes the person at the specified `INDEX`.
* The index refers to the index number shown in the displayed person list.
* The index **must be a positive integer** 1, 2, 3, ...​

Examples:
* `c-list` followed by `c-delete 2` deletes the 2nd employee in the contact list.
* `c-find Betsy` followed by `c-delete 1` deletes the 1st employee in the results of the `c-find` command.

#### 3.9 Clearing all entries : `c-clear`

Clears all entries from the contact list.

Format: `c-clear`

#### 3.10 Archiving an employee : `c-archive`

Archives the specified employee's contact detail from the tCheck.

Format: `c-archive INDEX`

* Archives the employee at the specified `INDEX`.
* The index refers to the index number shown in the displayed `employees' contact details` panel.
* The index **must be a positive integer** 1, 2, 3, ...​

<div markdown="span" class="alert alert-primary">:bulb: 

**Tip:**
Command `c-list` can be used first to show a list of all active employees' contact details. 
Then, `c-archive INDEX` can be used to archive a specific employee.
</div>

Examples:
* `c-list` followed by `c-archive 2` archives the 2nd person in the employees' contact details.
* `c-find Betsy` followed by `c-archive 1` archives the 1st person in the results of the `find` command.

#### 3.11 Archiving all employees : `c-archive-all`

Archives all employees' contact details from the tCheck.

Format: `c-archive-all`

#### 3.12 Listing all archived employees : `c-archive-list`

Shows a list of all archived employees' contact details in tCheck.

Format: `c-archive-list`

#### 3.13 Unarchiving an employee : `c-unarchive`

Unarchives the specified employee's contact detail from the tCheck's archived employee list.

Format: `c-unarchive INDEX`

* Unarchives the employee at the specified `INDEX`.
* The index refers to the index number shown in the displayed `employees' contact details` panel.
* The index **must be a positive integer** 1, 2, 3, ...

<div markdown="span" class="alert alert-primary">:bulb: 

**Tip:**
Command `c-archive-list` can be used first to show a list of all archived employees' contact details. 
Then, `c-unarchive INDEX` can be used to unarchive a specific employee.
</div>

Examples:
* `c-archive-list` followed by `c-unarchive 2` unarchives the 2nd person in the archived employees' contact details.

### 4. Commands - General <a name="commands-general"></a>
#### 4.1 Viewing help : `help`

Show a message explaining how to access the help page, which is the tCheck User Guide.

Format: `help`

Example: Let's say you want to find out how tCheck can help you manage the employees.
You can follow these instructions:

1. Type `help` into the _Command Box_.
2. Press "Enter" to execute the command.

Outcome:

1. tCheck will open the Help window, which shows a message explaining how to access the help page.

#### 4.2 Exiting the program : `exit`

Exits the program.

Format: `exit`

#### 4.3 Saving the data :

All tCheck data (i.e. contact details, ingredient data, sales data) are saved in the hard disk automatically after any
 command that changes the data. There is no need to save manually by entering any command.
 
## 5. FAQ <a name="FAQ"></a>

**Q**: Why does tCheck ignore additional or extra input that I add after single-word commands, like `help`? <br>
**A**: Any extra input after a single-word command, for example, the input `123` inside the input `c-list 123`, will
 be ignored because extra input does not affect the operation conducted by `c-list`. These single-word commands
 include: `s-list`, `s-rank`, `i-set-default`, `i-list`, `i-reset-all`, `i-restock`, `c-list`, `c-today`, `c-tomorrow`,
  `c-clear`, `c-archive-all`, `c-archive-list`, `help`, `exit`.

## Command summary <a name="command-summary"></a>

### Sales Tracking

Action | Format, Examples
-------|------------------------------
**Update**| `s-update A/NUM B/NUM C/NUM ...` <br> e.g., `s-update BSBM/100 BSBBT/120`
**List**| `s-list`
**Find**| `s-find KEYWORD [MORE_KEYWORDS] ...` <br> e.g., `s-find BSBM BSBBT`
**Rank**| `s-rank`


### Ingredients Tracking

Action | Format, Examples
-------|------------------------------
**Set a single ingredient**  | `i-set i/INGREDIENT_NAME m/AMOUNT` <br> e.g., `i-set i/Milk m/20`
**Set all ingredients**  | `i-set-all M/AMOUNT_FOR_MILK P/AMOUNT_FOR_PEARL B/AMOUNT_FOR_BOBA L/AMOUNT_FOR_BLACK_TEA G/AMOUNT_FOR_GREEN_TEA S/AMOUNT_FOR_BROWN_SUGAR` <br> e.g., `i-set-all M/20 P/20 B/20 L/50 G/20 S/100`
**Set all ingredients to default**  | `i-set-default` <br> e.g., `i-set-default`
**List**| `i-list`
**Find**| `i-find KEYWORD [MORE_KEYWORDS]`  <br> e.g., `i-find milk sugar`
**Reset all ingredients to zero**| `i-reset-all`
**View all ingredients that the user should restock**| `i-restock`

### Employees' Contact Details

Action | Format, Examples
-------|------------------------------
**Add** | `c-add n/NAME p/PHONE_NUMBER e/EMERGENCY_CONTACT a/ADDRESS [t/TAG] ...` <br> e.g., `c-add n/James Ho p/22224444 e/81234567 a/Blk 123 ABC Road t/Friday t/PartTime`
**List** | `c-list`
**List avalible manpower** | 1. **For today:**  `c-today`<br>2. **For the next day:**  `c-tomorrow` <br>
**Edit** | `c-edit INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMERGENCY_CONTACT] [t/TAG] ...`<br> e.g.,`c-edit 2 n/James Lee e/81234567`
**Find by name** | `c-find KEYWORD [MORE_KEYWORDS] ...`<br> e.g., `c-find James Jake`
**Find by tag(s)** | `c-tag-find KEYWORD [MORE_KEYWORDS] ...`<br> e.g., `c-tag-find Friday Monday PartTime`
**Delete** | `c-delete INDEX`<br> e.g., `c-delete 3`
**Clear** | `c-clear`
**Archive** |  1. **Archive \(1 employee\):**  `c-archive INDEX`<br> e.g., `c-archive 1` <br>2. **Archive \(all employees\):**  `c-archive-all` <br>3. **List all archived data:**  `c-archive-list`</br>
**Unarchive** | `c-unarchive INDEX`<br> e.g., `c-unarchive 1` 

### General

Action | Format, Examples
-------|------------------------------
**Help** | `help`
**Exit** | `exit`

 
