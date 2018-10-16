package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.commons.core.Messages.MESSAGE_UNKNOWN_COMMAND;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seedu.address.logic.commands.AddCommand;
import seedu.address.logic.commands.AddMedicalRecordCommand;
import seedu.address.logic.commands.AddMedicineCommand;
import seedu.address.logic.commands.ClearCommand;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.DeleteCommand;
import seedu.address.logic.commands.DisplayQueueCommand;
import seedu.address.logic.commands.DisplayServedPatientsCommand;
import seedu.address.logic.commands.EditCommand;
import seedu.address.logic.commands.EditMedicineCommand;
import seedu.address.logic.commands.ExitCommand;
import seedu.address.logic.commands.FindCommand;
import seedu.address.logic.commands.HelpCommand;
import seedu.address.logic.commands.HistoryCommand;
import seedu.address.logic.commands.ListCommand;
import seedu.address.logic.commands.ListStockCommand;
import seedu.address.logic.commands.MedicalCertificateCommand;
import seedu.address.logic.commands.ReceiptCommand;
import seedu.address.logic.commands.RedoCommand;
import seedu.address.logic.commands.ReferralLetterCommand;
import seedu.address.logic.commands.RegisterCommand;
import seedu.address.logic.commands.RemoveCommand;
import seedu.address.logic.commands.SelectCommand;
import seedu.address.logic.commands.ServeCommand;
import seedu.address.logic.commands.UndoCommand;

import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses user input.
 */
public class AddressBookParser {

    /**
     * Used for initial separation of command word and args.
     */
    private static final Pattern BASIC_COMMAND_FORMAT = Pattern.compile("(?<commandWord>\\S+)(?<arguments>.*)");

    /**
     * Parses user input into command for execution.
     *
     * @param userInput full user input string
     * @return the command based on the user input
     * @throws ParseException if the user input does not conform the expected format
     */
    public Command parseCommand(String userInput) throws ParseException {
        final Matcher matcher = BASIC_COMMAND_FORMAT.matcher(userInput.trim());
        if (!matcher.matches()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE));
        }

        final String commandWord = matcher.group("commandWord");
        final String arguments = matcher.group("arguments");
        switch (commandWord) {

        case AddCommand.COMMAND_WORD:
        case AddCommand.COMMAND_ALIAS:
            return new AddCommandParser().parse(arguments);

        case AddMedicineCommand.COMMAND_WORD:
            return new AddMedicineCommandParser().parse(arguments);

        case EditCommand.COMMAND_WORD:
        case EditCommand.COMMAND_ALIAS:
            return new EditCommandParser().parse(arguments);

        case EditMedicineCommand.COMMAND_WORD:
            return new EditMedicineCommandParser().parse(arguments);

        case SelectCommand.COMMAND_WORD:
        case SelectCommand.COMMAND_ALIAS:
            return new SelectCommandParser().parse(arguments);

        case DeleteCommand.COMMAND_WORD:
        case DeleteCommand.COMMAND_ALIAS:
            return new DeleteCommandParser().parse(arguments);

        case ClearCommand.COMMAND_WORD:
            return new ClearCommand();

        case FindCommand.COMMAND_WORD:
        case FindCommand.COMMAND_ALIAS:
            return new FindCommandParser().parse(arguments);

        case ListCommand.COMMAND_WORD:
        case ListCommand.COMMAND_ALIAS:
            return new ListCommand();

        case ListStockCommand.COMMAND_WORD:
            return new ListStockCommand();

        case HistoryCommand.COMMAND_WORD:
        case HistoryCommand.COMMAND_ALIAS:
            return new HistoryCommand();

        case ExitCommand.COMMAND_WORD:
            return new ExitCommand();

        case HelpCommand.COMMAND_WORD:
            return new HelpCommand();

        case UndoCommand.COMMAND_WORD:
        case UndoCommand.COMMAND_ALIAS:
            return new UndoCommand();

        case RedoCommand.COMMAND_WORD:
        case RedoCommand.COMMAND_ALIAS:
            return new RedoCommand();

        case AddMedicalRecordCommand.COMMAND_WORD:
        case AddMedicalRecordCommand.COMMAND_ALIAS:
            return new AddMedicalRecordCommandParser().parse(arguments);

        case ReceiptCommand.COMMAND_WORD:
        case ReceiptCommand.COMMAND_ALIAS:
            return new ReceiptCommandParser().parse(arguments);

        case MedicalCertificateCommand.COMMAND_WORD:
             return new MedicalCertificateCommandParser().parse(arguments);

        case ReferralLetterCommand.COMMAND_WORD:
             return new ReferralLetterCommandParser().parse(arguments);

        case DisplayQueueCommand.COMMAND_WORD:
            return new DisplayQueueCommand();

        case DisplayServedPatientsCommand.COMMAND_WORD:
        case DisplayServedPatientsCommand.COMMAND_ALIAS:
            return new DisplayServedPatientsCommand();

        case RegisterCommand.COMMAND_WORD:
        case RegisterCommand.COMMAND_ALIAS:
            return new RegisterCommandParser().parse(arguments);

        case ServeCommand.COMMAND_WORD:
            return new ServeCommand();

        case RemoveCommand.COMMAND_WORD:
            return new RemoveCommandParser().parse(arguments);

        default:
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }
    }

}
