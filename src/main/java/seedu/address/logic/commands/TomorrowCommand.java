package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.time.DayOfWeek;
import java.time.LocalDate;

import seedu.address.model.Model;

public class TomorrowCommand extends Command {
    public static final String COMMAND_WORD = "c-tomorrow";

    public static final String MESSAGE_SUCCESS = "Tomorrow is %2$s."
            + "\nThere are total %1$s employees working tomorrow."
            + "\nThey are listed below.";
    public static final String MESSAGE_NO_EMPLOYEE = "Tomorrow is %1$s."
            + "\nBased on the contact list, no employee is working tomorrow.";

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        LocalDate tmrDate = LocalDate.now().plusDays(1);
        DayOfWeek dayOfWeek = tmrDate.getDayOfWeek();

        switch (dayOfWeek) {
        case SUNDAY:
            model.updateFilteredPersonList(Model.PREDICATE_SHOW_ALL_SUNDAY_PERSONS);
            break;
        case MONDAY:
            model.updateFilteredPersonList(Model.PREDICATE_SHOW_ALL_MONDAY_PERSONS);
            break;
        case TUESDAY:
            model.updateFilteredPersonList(Model.PREDICATE_SHOW_ALL_TUESDAY_PERSONS);
            break;
        case WEDNESDAY:
            model.updateFilteredPersonList(Model.PREDICATE_SHOW_ALL_WEDNESDAY_PERSONS);
            break;
        case THURSDAY:
            model.updateFilteredPersonList(Model.PREDICATE_SHOW_ALL_THURSDAY_PERSONS);
            break;
        case FRIDAY:
            model.updateFilteredPersonList(Model.PREDICATE_SHOW_ALL_FRIDAY_PERSONS);
            break;
        case SATURDAY:
            model.updateFilteredPersonList(Model.PREDICATE_SHOW_ALL_SATURDAY_PERSONS);
            break;
        default:
            model.updateFilteredPersonList(person -> false);

        }
        if (model.getFilteredPersonList().size() == 0) {
            return new CommandResult(String.format(MESSAGE_NO_EMPLOYEE, tmrDate.getDayOfWeek()));
        }
        return new CommandResult(String.format(MESSAGE_SUCCESS, model.getFilteredPersonList().size(),
                tmrDate.getDayOfWeek()));
    }
}
