package com.lab.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "reports")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String studentName;
    private String studentId;
    private double exercises;
    private double assignment1;
    private double assignment2;
    private double assignment3;
    private double midterm;
    private double finalExam;
    private double averageGrade;
    private String letterGrade;

    /** Calculate the average grade of a student and calls the calcLetterGrade() method.
     */
    public void calcAverageGrade()
    {
        averageGrade = (10*exercises + 6*assignment1 + 12*assignment2 + 12*assignment3 + 30*midterm + 30*finalExam)/100;
        calcLetterGrade();
    }

    /** Calculates the letter grade based on average grade of a student.
     *  (Note: I have used Sheridan GPA marking scheme for calculation of letter grade)
     */
    public void calcLetterGrade()
    {
        if (averageGrade>=5)
        {
            letterGrade = "Passed";
        }
        else
        {
            letterGrade = "Not Passed";
        }
    }

}
