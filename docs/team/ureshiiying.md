---
layout: page
title: Tan Ying Hui's Project Portfolio Page
---

## Project: tCheck

tCheck is a desktop application that offers an integrated system to efficiently manage a bubble tea shop, of 
the (imaginary) brand T-sugar, by providing sales tracking, ingredient tracking and manpower management. It is 
optimized for Command Line Interface (CLI) users to update and retrieve the information more efficiently.

Given below are my contributions to the project.
 
* **Implementation**: Implemented the `SalesBook` model, and other related models, which are used to store sales
 tracking information.
  * What it does: Allows the app to record the sales data, as given by the user.
  * Justification: This is a necessary step for the app to work as stated. We can only add the commands after
   building these models.  
  * Highlights: This implementation was challenging, compared to adding new commands, as I
   had to incorporate a new entity into the original AB3.
  * Related PRs: [\#65](https://github.com/AY2021S1-CS2103T-T12-2/tp/pull/65), 
  [\#87](https://github.com/AY2021S1-CS2103T-T12-2/tp/pull/87)
 
* **New Feature**: Added ability to add and update sales of drinks.
  * What it does: Allows the user to add and update the sales of drink items, in the Sales Tracker, with a single
   command, `s-update`.
  * Justification: This feature allows the user to use the app for sales tracking purposes. It also allows for easy
   correction of errors.
  * Related PRs: [\#65](https://github.com/AY2021S1-CS2103T-T12-2/tp/pull/65),
  [\#144](https://github.com/AY2021S1-CS2103T-T12-2/tp/pull/144),
  [\#235](https://github.com/AY2021S1-CS2103T-T12-2/tp/pull/235)
  
* **New Feature**: Added ability to list the sales of drink.
  * What it does: Allows the user to list the sales of drink items in descending order, with `s-list`, in the Sales
   Tracker GUI.
  * Justification: This feature allows the user to view the full list of sales recorded. It also informs the user
    which drink has the most sales by giving the user a sorted view of the list.
  * Highlights: Intially, this was two separate features, one for listing in no order and one for listing in a
    sorted order. However, since tCheck already has a GUI to display the lists, users may not see the meaning behind having two features
    that perform similar listing functions. Thus, the two had been merged into one.
  * Related PRs: [\#79](https://github.com/AY2021S1-CS2103T-T12-2/tp/pull/79),
  [\#170](https://github.com/AY2021S1-CS2103T-T12-2/tp/pull/170),
  [\#235](https://github.com/AY2021S1-CS2103T-T12-2/tp/pull/235)
  
<div style="page-break-after: always;"></div>  
  
* **New Feature**: Implemented the Sales Tracker GUI
  * What it does: Allows the user to see a list of all drink items and their respective sales recorded, in a
   dedicated section of the GUI.
  * Justification: This improves the app significantly because the user will be able to view the recorded sales in an
   organised manner, instead of wordy texts.
  * Related PRs: [\#87](https://github.com/AY2021S1-CS2103T-T12-2/tp/pull/87), 
  [\#103](https://github.com/AY2021S1-CS2103T-T12-2/tp/pull/103)
   
* **Code contributed**: [RepoSense link](https://nus-cs2103-ay2021s1.github.io/tp-dashboard/#breakdown=true&search=ureshiiying&sort=groupTitle&sortWithin=title&since=2020-08-14&timeframe=commit&mergegroup=&groupSelect=groupByRepos&checkedFileTypes=docs~functional-code~test-code~other)

* **Project management**:
  * Created Milestone v1.1 and added issues assigned to the milestone.
  * Managed the milestones (eg. Ensuring that the milestones are closed punctually, adding deadlines for all the
   milestones)
  * Added Issues assigned to milestones v1.2, v1.3 and v1.4.
  * Managed release of `v1.3` on GitHub

* **Documentation**:
  * AboutUs page:
    * Updated my information in the AboutUs page of the project website.
  * User Guide:
    * Updated introduction.
    * Added a preface under the "Commands - Sales Tracking" section.
    * Added documentation for the features: `s-update` and `s-list`
    * Updated the organisation under the Command Summary Table, and added `s-update` and `s-list` into the table.
  * Developer Guide:
    * Added Introduction and purpose of document.
    * Added documentation and class diagram for the `SalesRecordEntry` sub-component under `Model` component.
    * Added implementation details of the `s-update` feature; also added the sequence diagram and activity diagrams
     within this explanation.
    * Added documentation for value proposition of the product under Appendix: Requirements.
    * Added manual test instructions for `s-update`, `s-list` features and saving data under Appendix: Instructions for
     manual testing.
  * Landing page of the product website (index.md):
    * Added and updated the documentation to match the current product details.
    
* **Community**:
  * PRs reviewed (with non-trivial review comments): 
    [\#62](https://github.com/AY2021S1-CS2103T-T12-2/tp/pull/62),
    [\#71](https://github.com/AY2021S1-CS2103T-T12-2/tp/pull/71),
    [\#74](https://github.com/AY2021S1-CS2103T-T12-2/tp/pull/74),
    [\#141](https://github.com/AY2021S1-CS2103T-T12-2/tp/pull/141),
    [\#252](https://github.com/AY2021S1-CS2103T-T12-2/tp/pull/252),
    [\#253](https://github.com/AY2021S1-CS2103T-T12-2/tp/pull/253),
    [\#254](https://github.com/AY2021S1-CS2103T-T12-2/tp/pull/254),
    [\#257](https://github.com/AY2021S1-CS2103T-T12-2/tp/pull/257),
    [\#259](https://github.com/AY2021S1-CS2103T-T12-2/tp/pull/259)
  * Reported bugs and suggestions for other teams in the class (examples: [1](https://github.com/ureshiiYing/ped/issues/2), [2](https://github.com/ureshiiYing/ped/issues/5), [3](https://github.com/ureshiiYing/ped/issues/6))
   
