package com.example.endeavorapp.ui

import com.example.endeavorapp.data.Questions

object setData {

    const val name:String="name"
    const val score:String="score"

   fun getQuestionLevel1():ArrayList<Questions>{
       var que:ArrayList<Questions> = arrayListOf()

       var question1 = Questions(
           1,
           "String in Java is a ?",

           "Class ",
           "Object ",
           "Variable ",
           "Character array",
           1
       )
       var question2 = Questions(
           2,
           "Which of the following method signatures is a valid declaration of an entry point in a Java application ?",

           "public void main(String[] args)",
           "public static void main()",
           "private static void start(String[] mydata)",
           " public static final void main(String[] mydata)",
           1
       )
       var question3 = Questions(
           3,
           "What is the correct file name extension for a file compiled in Java bytecode??",

           ".java",
           " .class",
           ".bytecode",
           ".dll",
           2
       )
       var question4 = Questions(
           4,
           "Which of the following is not a valid code comment in Java?",

           " // it's a comment",
           " / *** this is a comment *** /",
           " # this is a comment",
           " / * this is a comment **** /",
           3
       )

       var question5 = Questions(
           5,
           "What is the result of compiling and running the following class ?\n" +
                   "public class DevInfo {\n" +
                   "     \n" +
                   "    int visites = 10;\n" +
                   "     \n" +
                   "    public static void main(String[] data) {\n" +
                   "        int visites = 5;\n" +
                   "        System.out.print(visites + visites);\n" +
                   "    }\n" +
                   "}",

           "It compiles but throws an exception at runtime",
           "It compiles and displays 5",
           "It compiles and displays 15",
           " It does not compile",
           4
       )
       var question6 = Questions(
           6,
           "Which package is imported into each default Java class ?",

           "java.util",
           "java.lang",
           "system.lang",
           "java.system",
           2
       )

       que.add(question1)
       que.add(question2)
       que.add(question3)
       que.add(question4)
       que.add(question5)
       que.add(question6)
       return que
   }


    fun getQuestionLevel2():ArrayList<Questions>{
        var queLevel2:ArrayList<Questions> = arrayListOf()

        var question1 = Questions(
            1,
            "Which of the following statements does not compile?",

            "double num1, int num2 = 0;",
            "int num1, num2;",
            "int num1, num2 = 0;",
            "int num1 = 0, num2 = 0;",
            1
        )
        var question2 = Questions(
            2,
            "What is the result of the following program?\n" +
                    "public static void main(String... args) { \n" +
                    "    String str1, str2 = \"meknes\";\n" +
                    "    chair = str1 + str2; \n" +
                    "    System.out.println(chair); \n" +
                    "}",

            "meknes",
            "meknesmeknes",
            "nullmeknes",
            " The code does not compile",
            4
        )
        var question3 = Questions(
            3,
            "How many of the following methods are compiled ?\n" +
                    "public String convert(int value) { \n" +
                    "    return value.toString(); \n" +
                    "}\n" +
                    "public String convert(Integer value){ \n" +
                    "    return value.toString(); \n" +
                    "}\n" +
                    "public String convert(Object value){ \n" +
                    "    return value.toString(); \n" +
                    "}  ",

            "Any",
            " One",
            "Two",
            "Three",
            3
        )
        var question4 = Questions(
            4,
            "Which of the following is not valid order for the elements of a class ?",

            "Constructor, instance variables, method names",
            "Instance variables, constructor, method names",
            "Method names, instance variables, constructor",
            "None of the above: all orders are valid",
            4
        )

        var question5 = Questions(
            5,
            "How many of the types double, int, and short could fill in the blank for this code to produce output 0 \n?" +
                    "\n"+
                    "public static void main(String[] args) { \n" +
                    "    ------------uneValuer; \n" +
                    "    System.out.println(uneValuer); \n" +
                    "} ",

            "Any",
            "One",
            "Two",
            "Three",
            1
        )
        var question6 = Questions(
            6,
            "Which of the following statements is true about primitives ?",

            "You can call methods on a primitive",
            "You can convert a primitive to a wrapper class object just by assigning it",
            "You can convert a Wrapper class object to a primitive by calling valueOf ()",
            " You can store a primitive directly in an ArrayList",
            2
        )

        queLevel2.add(question1)
        queLevel2.add(question2)
        queLevel2.add(question3)
        queLevel2.add(question4)
        queLevel2.add(question5)
        queLevel2.add(question6)
        return queLevel2
    }
}