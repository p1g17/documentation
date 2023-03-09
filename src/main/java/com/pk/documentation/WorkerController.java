package com.pk.documentation;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class WorkerController {
    private List<Worker> workers = createList();

    @RequestMapping(value = "/workers", method = RequestMethod.GET, produces = "application/json")
    public List<Worker> firstPage() {
        return workers;
    }

    @DeleteMapping(path = {"/{id}"})
    public Worker delete(@PathVariable("id") int id) {
        Worker deletedEmp = null;
        for (Worker emp : workers) {
            if (emp.getEmpId().equals(id)) {
                workers.remove(emp);
                deletedEmp = emp;
                break;
            }
        }
        return deletedEmp;
    }

    @PostMapping
    public Worker create(@RequestBody Worker user) {
        workers.add(user);
        System.out.println(workers);
        return user;
    }

    private static List<Worker> createList() {
        List<Worker> tempWorkers = new ArrayList<>();
        Worker emp1 = new Worker();
        emp1.setName("emp1");
        emp1.setDesignation("manager");
        emp1.setEmpId("1");
        emp1.setSalary(3000);

        Worker emp2 = new Worker();
        emp2.setName("emp2");
        emp2.setDesignation("developer");
        emp2.setEmpId("2");
        emp2.setSalary(3000);
        tempWorkers.add(emp1);
        tempWorkers.add(emp2);
        return tempWorkers;
    }
}
