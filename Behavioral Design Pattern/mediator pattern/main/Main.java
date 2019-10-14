package main;

import java.util.Scanner;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

import mediators.ExamControllerOffice;
import participants.Examiner;
import participants.Examinee;
import results.ExamScript;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    public static void main(String[] args) {
        /* initial part */
        ExamControllerOffice examControllerOffice = new ExamControllerOffice();  // mediator

        List<Examiner> examiners = new ArrayList<>();
        List<Examinee> examinees = new ArrayList<>();

        System.out.print("enter examiner number(>0 AND <=examinee number): ");
        int examinerNum = scanner.nextInt();
        System.out.print("enter examinee number(>0 AND >=examiner number): ");
        int examineeNum = scanner.nextInt();

        if((examinerNum > examineeNum) || (examinerNum < 1) || (examineeNum < 1)) {
            System.out.println("\n"+"input not accepted, exiting...");
            return ;
        }

        for(int i=0; i<examinerNum; i++) {
            examiners.add(new Examiner(examControllerOffice, i+1));
        }

        for(int i=0; i<examineeNum; i++) {
            examinees.add(new Examinee(examControllerOffice, i+1));
        }

        examControllerOffice.setExaminers(examiners);
        examControllerOffice.setExaminees(examinees);

        /* preparing exam scripts */
        List<List<ExamScript>> arrayExamScripts = new ArrayList<>();
        List<ExamScript> temp;

        for(int i=0; i<examinerNum; i++) {
            temp = new ArrayList<>();
            arrayExamScripts.add(temp);
        }

        for(int i=0, examinerCount=0; i<examineeNum; i++) {
            if(examinerCount >= examinerNum) {
                examinerCount = 0;
            }

            arrayExamScripts.get(examinerCount).add(new ExamScript(examinerCount+1, i+1, random.nextInt(51)+50));  // NOTICE: marks between 50 and 100
            examinerCount++;
        }

        /* exam scripts and marksheets sent by examiners to examinees */
        for(int i=0; i<examinerNum; i++) {
            System.out.println("");
            examiners.get(i).sendExamPackage(arrayExamScripts.get(i));
        }

        /* reexamination part */
        while(true) {
            System.out.print("\n" + "enter examinee id for reexamination(0 to exit): ");
            int id = scanner.nextInt();

            if (id == 0) {
                break;

            } else if (id < 1 || id > examineeNum) {
                System.out.println("\n" + "invalid id given, try again...");

            } else {
                examinees.get(id-1).requestReexamination();
            }
        }

        return ;
    }
}
