package org.example;

import java.util.Set;
import java.util.HashSet;
import java.util.stream.Collectors;

public class TaskData {
    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;
    private Set<Task> carolsTasks;
    private Set<Task> unassignedTasks;

    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks, Set<Task> carolsTasks, Set<Task> unassignedTasks) {
        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;
        this.unassignedTasks = unassignedTasks;
    }

    public Set<Task> getTasks(String name) {
        switch (name.toLowerCase()) {
            case "ann":
                return annsTasks;
            case "bob":
                return bobsTasks;
            case "carol":
                return carolsTasks;
            case "all":
                return getUnion(Set.of(annsTasks, bobsTasks, carolsTasks, unassignedTasks));
            default:
                return new HashSet<>();
        }
    }

    public Set<Task> getUnion(Set<Set<Task>> sets) {
        return sets.stream()
                .flatMap(Set::stream)
                .collect(Collectors.toSet());
    }

    public Set<Task> getIntersection(Set<Task> set1, Set<Task> set2) {
        return set1.stream()
                .filter(set2::contains)
                .collect(Collectors.toSet());
    }

    public Set<Task> getDifferences(Set<Task> set1, Set<Task> set2) {
        return set1.stream()
                .filter(task -> !set2.contains(task))
                .collect(Collectors.toSet());
    }

    public Set<Task> getUnassignedTasks() {
        return unassignedTasks;
    }
    public Set<Task> getUnion(Set<Task> taskSet, Set<Task> taskSet2) {
        return taskSet;
    }

    @Override
    public String toString() {
        return "TaskData{" +
                "annsTasks=" + annsTasks +
                ", bobsTasks=" + bobsTasks +
                ", carolsTasks=" + carolsTasks +
                ", unassignedTasks=" + unassignedTasks +
                '}';
    }


}
