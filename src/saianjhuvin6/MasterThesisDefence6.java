package saianjhuvin6;

import java.io.InvalidObjectException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;

public class MasterThesisDefence6 {
    private String studentName,defenceDate, defenceTime, thesisTitle, thesisAbstract,
            nameOfSupervisor,thesisReader1, thesisReader2, defenceChair, approvalSupervisor,approvalReader1,approvalReader2,
            approvalDefenceChair,confirmSupervisor,confirmReader1,confirmReader2,confirmDefenceChair, announcement, givenApprovalDateString;
    String pattern = "MM-dd-yyyy";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    Date date, announcementDate, givenApprovalDate, date6FinalDate;
    Boolean boolConfirmSchedule, approvalGiven=false,boolCheckApprovalStatus=false;
    Map<String,String>map6= new HashMap<>();
    long ltime, ltime6FinalDate;
    List<MasterThesisDefenceList> masterThesisDefenceListList=new ArrayList<>();
    MasterThesisDefenceList masterThesisDefenceListObject;
    public void createSchedule(String studentName,String defenceDate, String defenceTime, String thesisTitle, String thesisAbstract, String nameOfSupervisor,String thesisReader1, String thesisReader2, String defenceChair){
         this.studentName=studentName;
         this.defenceDate=defenceDate;
         this.defenceTime=defenceTime;
         this.thesisTitle=thesisTitle;
         this.thesisAbstract=thesisAbstract;
         this.nameOfSupervisor=nameOfSupervisor;
         this.thesisReader1=thesisReader1;
         this.thesisReader2=thesisReader2;
         this.defenceChair=defenceChair;
         masterThesisDefenceListObject=new MasterThesisDefenceList(studentName,defenceDate,defenceTime,thesisTitle,thesisAbstract,nameOfSupervisor,thesisReader1,thesisReader2, defenceChair);
         if(!masterThesisDefenceListList.contains(masterThesisDefenceListObject))
             masterThesisDefenceListList.add(masterThesisDefenceListObject);
     }

      public Boolean getApprovalSupervisor(String approvalSupervisor,String approvalReader1,String approvalReader2,String approvalDefenceChair,String givenApprovalDateString) throws Exception{
         checkApprovalStatus();
          String strPattern = "^(0[1-9]|1[012])-(0[1-9]|[12][0-9]|[3][01])-\\d{4}$";
          if(givenApprovalDateString.matches( strPattern )) {
              SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
              //to reject invalid dates
              sdf.setLenient(false);
              //parse the actual date
              try {
                  //throws ParseException in case of invalid date
                  sdf.parse(givenApprovalDateString);

                  //at this point the date is valid
                  return true;
              } catch (ParseException pe) {
                  //do nothing

              }


              if (approvalGiven == false) {
                  if (approvalSupervisor == "no")
                      System.out.println("Approval not given by the supervisor");
                  approvalGiven = false;
                  //       given approval date should be greater than announcement date but less than 15 days
//         Assuming that the approval happens only after the announcement date
                  for (MasterThesisDefenceList m : masterThesisDefenceListList) {
//                Get the defence date and subtract 7 days from it and set announcement date to the new date and set the announcement =yes
                      date = simpleDateFormat.parse(m.defenceDate.toString());
                      ltime6FinalDate = date.getTime() + 14 * 24 * 60 * 60 * 1000;
                      ltime = date.getTime() + 7 * 24 * 60 * 60 * 1000;
                      announcementDate = new Date(ltime);
                      announcement = "yes";
                      date6FinalDate = new Date(ltime6FinalDate);
                      System.out.println(announcementDate);
                      System.out.println(date6FinalDate);
                      givenApprovalDate = simpleDateFormat.parse(givenApprovalDateString);
                      if (!givenApprovalDate.after(announcementDate) && !date6FinalDate.before(announcementDate)) {
                          if (approvalSupervisor == "yes") {
                              if (approvalReader1 == "yes" && approvalReader2 == "yes" && approvalDefenceChair == "yes") {
                                  System.out.println("Given approval date= " + givenApprovalDate + " Announcement date=" + announcementDate + " Final approval date= " + date6FinalDate);
                                  System.out.println("Student has submitted the thesis on time, hence the approval is completed within the timeline " + givenApprovalDate);
                                  approvalGiven = true;
                              }
                          }
                      } else if (approvalSupervisor == "yes") {
                          if (approvalReader1 == "yes" && approvalReader2 == "yes" && approvalDefenceChair == "yes") {
                              System.out.println("Given approval date= " + givenApprovalDate + " Announcement date=" + announcementDate + " Final approval date= " + date6FinalDate);
                              System.out.println("Student has  not submitted the thesis on time, hence the approval process took time " + givenApprovalDate);
                              approvalGiven = true;
                          }
                      } else if (approvalGiven == true)
                          System.out.println("Approval has already been given");
                  }
              }
          }
        return approvalGiven;
      }
      public void close(){
          boolCheckApprovalStatus=true;
      }


    public List<MasterThesisDefenceList> getMasterThesisDefenceListList() {
        return masterThesisDefenceListList;
    }
    public void setMasterThesisDefenceListList(List<MasterThesisDefenceList> masterThesisDefenceListList) {
        this.masterThesisDefenceListList = masterThesisDefenceListList;
    }
    public MasterThesisDefenceList getMasterThesisDefenceListObject() {
        return masterThesisDefenceListObject;
    }
    public void setMasterThesisDefenceListObject(MasterThesisDefenceList masterThesisDefenceListObject) {
        this.masterThesisDefenceListObject = masterThesisDefenceListObject;
    }
    public void checkApprovalStatus() throws Exception{
        if(boolCheckApprovalStatus){
            throw  new InvalidObjectException("Invalid Object");
        }
    }
    class MasterThesisDefenceList{
         private String studentName,defenceDate, defenceTime, thesisTitle, thesisAbstract,
                 nameOfSupervisor,thesisReader1, thesisReader2, defenceChair;
         public MasterThesisDefenceList() {}
         public MasterThesisDefenceList(String studentName,String defenceDate, String defenceTime, String thesisTitle,
                                        String thesisAbstract, String nameOfSupervisor,String thesisReader1, String thesisReader2,
                                        String defenceChair) {
             this.studentName=studentName;
             this.defenceDate=defenceDate;
             this.defenceTime=defenceTime;
             this.thesisTitle=thesisTitle;
             this.thesisAbstract=thesisAbstract;
             this.nameOfSupervisor=nameOfSupervisor;
             this.thesisReader1=thesisReader1;
             this.thesisReader2=thesisReader2;
             this.defenceChair=defenceChair;
         }

         public String getStudentName() {
             return studentName;
         }

         public void setStudentName(String studentName) {
             this.studentName = studentName;
         }

         public String getDefenceDate() {
             return defenceDate;
         }

         public void setDefenceDate(String defenceDate) {
             this.defenceDate = defenceDate;
         }

         public String getDefenceTime() {
             return defenceTime;
         }

         public void setDefenceTime(String defenceTime) {
             this.defenceTime = defenceTime;
         }

         public String getThesisTitle() {
             return thesisTitle;
         }

         public void setThesisTitle(String thesisTitle) {
             this.thesisTitle = thesisTitle;
         }

         public String getThesisAbstract() {
             return thesisAbstract;
         }

         public void setThesisAbstract(String thesisAbstract) {
             this.thesisAbstract = thesisAbstract;
         }

         public String getNameOfSupervisor() {
             return nameOfSupervisor;
         }

         public void setNameOfSupervisor(String nameOfSupervisor) {
             this.nameOfSupervisor = nameOfSupervisor;
         }

         public String getThesisReader1() {
             return thesisReader1;
         }

         public void setThesisReader1(String thesisReader1) {
             this.thesisReader1 = thesisReader1;
         }

         public String getThesisReader2() {
             return thesisReader2;
         }

         public void setThesisReader2(String thesisReader2) {
             this.thesisReader2 = thesisReader2;
         }

         public String getDefenceChair() {
             return defenceChair;
         }

         public void setDefenceChair(String defenceChair) {
             this.defenceChair = defenceChair;
         }

         @Override
         public String toString() {
             return "MasterThesisDefenceList{" +
                     "studentName='" + studentName + '\'' +
                     ", defenceDate='" + defenceDate + '\'' +
                     ", defenceTime='" + defenceTime + '\'' +
                     ", thesisTitle='" + thesisTitle + '\'' +
                     ", thesisAbstract='" + thesisAbstract + '\'' +
                     ", nameOfSupervisor='" + nameOfSupervisor + '\'' +
                     ", thesisReader1='" + thesisReader1 + '\'' +
                     ", thesisReader2='" + thesisReader2 + '\'' +
                     ", defenceChair='" + defenceChair + '\'' +
                     '}';
         }

         @Override
         public boolean equals(Object o) {
             if (this == o) return true;
             if (o == null || getClass() != o.getClass()) return false;
             MasterThesisDefenceList that = (MasterThesisDefenceList) o;
             if(studentName.equals(that.studentName) &&
                     defenceDate.equals(that.defenceDate) &&
                     defenceTime.equals(that.defenceTime) &&
                     thesisTitle.equals(that.thesisTitle) &&
                     thesisAbstract.equals(that.thesisAbstract) &&
                     nameOfSupervisor.equals(that.nameOfSupervisor) &&
                     thesisReader1.equals(that.thesisReader1) &&
                     thesisReader2.equals(that.thesisReader2) &&
                     defenceChair.equals(that.defenceChair)){
                 return true;
             } else{ return  false;}
         }

         @Override
         public int hashCode() {
             return Objects.hash(studentName, defenceDate, defenceTime, thesisTitle, thesisAbstract, nameOfSupervisor, thesisReader1, thesisReader2, defenceChair);
         }
     }

    public static void main(String[] args) throws Exception {
        Boolean approvalGiven=false;
        MasterThesisDefence6 masterThesisDefenceObject=new MasterThesisDefence6();
//
            masterThesisDefenceObject.createSchedule("Sai6","10-01-2021","06:09:01","sai thesis","sai abstract","sai supervisor", "sai reder1", "sai reader2","sai defence chair");
//        Check if the below condition returns true, if so proceed

//            approvalGiven =masterThesisDefenceObject.getApprovalSupervisor("yes","yes","yes","yes","10-06-2021");
//            System.out.println(approvalGiven);
        approvalGiven=masterThesisDefenceObject.getApprovalSupervisor("yes","yes","yes","yes","10-09-2021");
//        masterThesisDefenceObject.getApprovalSupervisor("no","yes","yes","yes","10-09-2021");

//        MasterThesisDefence6 masterThesisDefenceObject6=new MasterThesisDefence6();
//        masterThesisDefenceObject6.createSchedule("Sai6","10-01-2021","06:09:01","sai thesis","sai abstract","sai supervisor", "sai reder1", "sai reader2","sai defence chair");
//        approvalGiven =masterThesisDefenceObject6.getApprovalSupervisor("no","yes","yes","yes","10-09-2021");
        System.out.println(approvalGiven);
//
     }
}
//set flag to false for that object,
//if object exists in that list and flag ==false, then do not exceute theat method