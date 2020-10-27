package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.time.DayOfWeek;
import java.time.LocalDate;

import seedu.address.model.Model;

public class TodayCommand extends Command {
    public static final String COMMAND_WORD = "c-today";

    public static final String MESSAGE_SUCCESS = "Today is %2$s."
            + "\nThere are total %1$s employees working today."
            + "\nThey are listed below.";
    public static final String MESSAGE_NO_EMPLOYEE = "Today is %1$s."
            + "\nBased on the contact list, no employee is working today.";

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        LocalDate todayDate = LocalDate.now();
        DayOfWeek dayOfWeek = todayDate.getDayOfWeek();

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
            return new CommandResult(String.format(MESSAGE_NO_EMPLOYEE, todayDate.getDayOfWeek()));
        }
        return new CommandResult(String.format(MESSAGE_SUCCESS, model.getFilteredPersonList().size(),
                todayDate.getDayOfWeek()));
    }
}
