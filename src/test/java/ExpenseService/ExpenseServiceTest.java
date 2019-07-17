package ExpenseService;

import ExpenseService.Exception.UnexpectedProjectTypeException;
import ExpenseService.Expense.ExpenseType;
import ExpenseService.Project.Project;
import org.junit.jupiter.api.Test;

import static ExpenseService.Expense.ExpenseType.*;
import static ExpenseService.Project.ProjectType.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ExpenseServiceTest {
    @Test
    void should_return_internal_expense_type_if_project_is_internal() throws UnexpectedProjectTypeException {
        // given
        Project project = new Project(INTERNAL, "Project");
        ExpenseService expenseService = new ExpenseService();

        // when
        ExpenseType expenseCode = expenseService.getExpenseCodeByProjectTypeAndName(project);

        // then
        assertThat(expenseCode).isEqualTo(INTERNAL_PROJECT_EXPENSE);
    }

    @Test
    void should_return_expense_type_A_if_project_is_external_and_name_is_project_A() throws UnexpectedProjectTypeException {
        // given
        Project project = new Project(EXTERNAL, "Project A");
        ExpenseService expenseService = new ExpenseService();

        // when
        ExpenseType expenseCode = expenseService.getExpenseCodeByProjectTypeAndName(project);

        // then
        assertThat(expenseCode).isEqualTo(EXPENSE_TYPE_A);
    }

    @Test
    void should_return_expense_type_B_if_project_is_external_and_name_is_project_B() throws UnexpectedProjectTypeException {
        // given
        Project project = new Project(EXTERNAL, "Project B");
        ExpenseService expenseService = new ExpenseService();

        // when
        ExpenseType expenseCode = expenseService.getExpenseCodeByProjectTypeAndName(project);

        // then
        assertThat(expenseCode).isEqualTo(EXPENSE_TYPE_B);

    }

    @Test
    void should_return_other_expense_type_if_project_is_external_and_has_other_name() throws UnexpectedProjectTypeException {
        // given
        Project project = new Project(EXTERNAL, "Project C");
        ExpenseService expenseService = new ExpenseService();

        // when
        ExpenseType expenseCode = expenseService.getExpenseCodeByProjectTypeAndName(project);

        // then
        assertThat(expenseCode).isEqualTo(OTHER_EXPENSE);
    }

    @Test
    void should_throw_unexpected_project_exception_if_project_is_invalid() {
        // given
        Project project = new Project(UNEXPECTED_PROJECT_TYPE, "Project B");
        ExpenseService expenseService = new ExpenseService();

        // when
        // then
        assertThrows(UnexpectedProjectTypeException.class, () -> expenseService.getExpenseCodeByProjectTypeAndName(project));
    }
}