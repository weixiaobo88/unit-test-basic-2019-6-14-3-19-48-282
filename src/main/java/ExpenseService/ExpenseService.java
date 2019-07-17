package ExpenseService;

import ExpenseService.Expense.ExpenseType;
import ExpenseService.Project.*;
import ExpenseService.Exception.*;

import static ExpenseService.Expense.ExpenseType.*;
import static ExpenseService.Project.ProjectType.*;

class ExpenseService {
    static ExpenseType getExpenseCodeByProjectTypeAndName(Project project) throws UnexpectedProjectTypeException {
        ProjectType projectType = project.getProjectType();
        if(projectType == INTERNAL){
            return INTERNAL_PROJECT_EXPENSE;
        }else{
            if(projectType == EXTERNAL){
                String projectName = project.getProjectName();
                if(projectName.equals("Project A")){
                    return EXPENSE_TYPE_A;
                }

                if(projectName.equals("Project B")){
                    return EXPENSE_TYPE_B;
                }

                return OTHER_EXPENSE;
            }

            throw new UnexpectedProjectTypeException("You enter invalid project type");
        }
    }
}
