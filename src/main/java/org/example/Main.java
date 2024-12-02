package org.example;



import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // Örnek görevler oluşturma
        Task task1 = new Task("Project A", "Task 1", "Ann", Status.IN_QUEUE,Priority.HIGH );
        Task task2 = new Task("Project A", "Task 2", "Ann",  Status.ASSIGNED, Priority.MED);
        Task task3 = new Task("Project B", "Task 3", "Bob",  Status.IN_PROGRESS ,Priority.LOW);
        Task task4 = new Task("Project B", "Task 4", "Carol",  Status.IN_QUEUE ,Priority.MED);
        Task task5 = new Task("Project C", "Task 5", null,  Status.ASSIGNED , Priority.HIGH);

        // Görev setlerini oluşturma
        Set<Task> annsTasks = new HashSet<>();
        annsTasks.add(task1);
        annsTasks.add(task2);

        Set<Task> bobsTasks = new HashSet<>();
        bobsTasks.add(task3);

        Set<Task> carolsTasks = new HashSet<>();
        carolsTasks.add(task4);

        Set<Task> unassignedTasks = new HashSet<>();
        unassignedTasks.add(task5);

        // TaskData nesnesi oluşturma
        TaskData taskData = new TaskData(annsTasks, bobsTasks, carolsTasks, unassignedTasks);

        // Görevleri listeleme
        System.out.println("Tüm çalışanların üzerindeki görevler:");
        taskData.getTasks("all").forEach(System.out::println);

        System.out.println("\nAnn'in görevleri:");
        taskData.getTasks("ann").forEach(System.out::println);

        System.out.println("\nBob'un görevleri:");
        taskData.getTasks("bob").forEach(System.out::println);

        System.out.println("\nCarol'un görevleri:");
        taskData.getTasks("carol").forEach(System.out::println);

        System.out.println("\nAtanmamış görevler:");
        taskData.getUnassignedTasks().forEach(System.out::println);

        // Örnek union, intersect, ve difference işlemleri
        System.out.println("\nUnion of Ann's and Bob's tasks:");
        taskData.getUnion(Set.of(annsTasks, bobsTasks)).forEach(System.out::println);

        System.out.println("\nIntersection of Ann's and Bob's tasks:");
        taskData.getIntersection(annsTasks, bobsTasks).forEach(System.out::println);

        System.out.println("\nDifference between Ann's and Bob's tasks:");
        taskData.getDifferences(annsTasks, bobsTasks).forEach(System.out::println);
    }
}
