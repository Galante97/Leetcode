//Imagine you have a call center with three levels of employees: respondent, manager, and
//Director. An incoming call must be first allocated to a respondent who is free. if the respondent cant
//handle the call, they must escalate the call to the manager. If the manager is not free or cant handle it,
//then the call should be escalated to a director. Design a call center

//Q: how many of each employees are there? 10 respondents, 4 manager, and 2 directors
public class CallHandler {
    /* 3 levels of employees */
    private int LEVELS = 3;

    private int NUM_RESPONDENTS = 10;
    private int NUM_MANAGERS = 4;
    private int NUM_DIRECTORS = 2;

    /**
    * employeeLevels[0] = respondent
    * employeeLevels[1] = manager
    * employeeLevels[2] = director
    **/
    List<List<Employee>> employeeLevels;

    /* Queue for each calls rank */
    List<List<Call>> callQueues;

    // Constructor
    CallHandler() {
        employeeLevels = new List<List<Employee>>();
        callQueues = new List<List<Call>>();
    }

    // Get the frist available employee who can handle the call
    public Employee GetHandlerForCall(Call call) { }
    

    // Routes the call to an available employee or saves it in a queue
    public void DispatchCall(Caller caller) {
        Call call = new Call(caller);
        DispatchCall(call);
    }

    public void DispatchCall(Call call) {
        //Try to route the call to an employee with min rank
        Employee emp = GetHandlerForCall(call);
        if (emp != null) {
            emp.RecieveCall(call);
            call.SetHandler(emp);
        } else { //place in queue
            call.Replay("Please wait for the free employee to reply");
            callQueues[call.getRank()].Add(call);
        }

    }

    // An employee got free. Look for waiting call that emp can serve. Return
    // true if we assign a call, false otherwise 
    public boolean AssignCall(Employee employee) {}
}

// Call represents call from user 
public class Call {
    //min rank of employee who can handle this call
    private Rank rank;

    //person who is calling this call
    private Caller caller;

    // Employee who is handling this call
    private Employee handler;

    //Constructor
    Call(Caller c) {
        rank = Rank.Respondent;
        caller = c;
    }

    //Set employee handling this call
    public void SetHandler(Employee e) {}
    public Rank GetRank() {return rank;}
    public void SetRank(Rank r) { rank = r; }
    public Rank IncrementRank() {}
    public void Disconnect() {}
}

public abstract class Employee {
    private Call currentCall = null;
    protected Rank rank;

    //Constructor
    Employee() { }

    // Start conversation
    public void RecieveCall(Call call) {}

    // Is resolved, finish the call
    public void CallCompleted() {}

    // The issue has not been resolved. Escalate the call and assign new call to the employee
    public void EscalateAndReassign() {}

    // Assign a new call to an employee, if the employee is free
    public boolean AssignNewCall() {}

    //Return whether or not the employee is free
    public boolean IsFree() {return currentCall == null;}

    public Rank GetRank() {return rank;}

}

public class Respondent : Employee {
    public Respondent() {
        rank = Rank.Respondent;
    }
}

public class Manager : Employee {
    public Manager() {
        rank = Rank.Manager;
    }
}

public class Director : Employee {
    public Director() { 
        rank = Rank.Director;
    }

}