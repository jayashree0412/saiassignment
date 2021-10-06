package saianjhuvin6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Game6 {
    private String teamName, win,createLeaderBoardListObj;
    private Integer scoreTeam1, scoreTeam2,countOfScoreTeam1, countOfScoreTeam2, numberOfGames=0,
            numberOfGamesTie=0,sumOfPointsOfTeam1=0,sumOfPointsOfTeam2=0, numberOfGamesForPoints, NumberOfGamesTie6=0;
    List<String> teamNamesList= new ArrayList<String>();
    List<ScoresList> scoresList6=new ArrayList<>();
    List<String> createLeaderBoardList= new ArrayList<String>();
    ScoresList scoresListObj;
    public boolean addTeam(String teamName){
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
        Matcher matcher = pattern.matcher(teamName);
        boolean isStringContainsSpecialCharacter = matcher.find();
        if(teamName==null){
            System.out.println("Team name is null");
            return false;
        }
        else if(teamName==""){
            System.out.println("Team name is empty");
            return false;
        }
        else if(teamName.length() >0 && teamName.length()==1){
            System.out.println("Team name cannot be less than 1 character");
            return false;
        }
        else if(isStringContainsSpecialCharacter){
            System.out.println("Team name contains special character");
            return false;
        }
        this.teamName= teamName;
        if(!teamNamesList.contains(teamName))
        teamNamesList.add(teamName);
        return true;
    }
    public boolean recordGameOutcome(String team1, String team2, int scoreTeam1, int scoreTeam2){
        if((!teamNamesList.contains(team1)||(!teamNamesList.contains(team2))))
            return false;
        else if((!teamNamesList.contains(team1)&&(!teamNamesList.contains(team2))))
            return false;
        else if((scoreTeam1<0||scoreTeam2<0))
            return false;
        else if((scoreTeam1==0 && scoreTeam2==0))
            return false;
        else if((scoreTeam1>0||scoreTeam2>0))
//            Don't enter scores with decimal digits
            scoreTeam1= Math.round(scoreTeam1);
            this.scoreTeam1=scoreTeam1;
            scoreTeam2=Math.round(scoreTeam2);
            this.scoreTeam2=scoreTeam2;
        win=whoWon(scoreTeam1,scoreTeam2);
        passingWinString(win);
            return true;
    }
    public String whoWon(int scoreTeam1, int scoreTeam2){
        countOfScoreTeam1=0;
        countOfScoreTeam2=0;
        if(scoreTeam1==scoreTeam2){
            numberOfGames++;
            numberOfGamesTie++;
            countOfScoreTeam1=0;
            countOfScoreTeam2=0;
            scoreTeam1=0;
            scoreTeam2=0;
            scoresListObj= new ScoresList(countOfScoreTeam1,countOfScoreTeam2,numberOfGames,scoreTeam1,scoreTeam2,numberOfGamesTie);
            if(!scoresList6.contains(scoresListObj))
                scoresList6.add(scoresListObj);
            NumberOfGamesTie6=numberOfGamesTie;
            System.out.println("NumberOfGamesTie6 "+NumberOfGamesTie6);
        }
        else if(scoreTeam1>scoreTeam2) {
            countOfScoreTeam1++;
            numberOfGames++;
            numberOfGamesTie=0;
            sumOfPointsOfTeam1=sumOfPointsOfTeam1+scoreTeam1;
            scoresListObj= new ScoresList(countOfScoreTeam1,countOfScoreTeam2,numberOfGames,scoreTeam1,scoreTeam2,numberOfGamesTie);
            if(!scoresList6.contains(scoresListObj))
            scoresList6.add(scoresListObj);
            win = "scoreTeam1 won "+countOfScoreTeam1;
        }
        else if(scoreTeam2>scoreTeam1){
          countOfScoreTeam2++;
            numberOfGames++;
            numberOfGamesTie=0;
            sumOfPointsOfTeam2=sumOfPointsOfTeam2+scoreTeam2;
            scoresListObj= new ScoresList(countOfScoreTeam1,countOfScoreTeam2,numberOfGames,scoreTeam1,scoreTeam2,numberOfGamesTie);
            if(!scoresList6.contains(scoresListObj))
            scoresList6.add(scoresListObj);
          win="scoreTeam2 won "+countOfScoreTeam2;
        }


//        System.out.println(scoresList6.size());
//        for(Object o:scoresList6)
//            System.out.println(o);
        return win;
    }
    public void totalPoints(){
       numberOfGamesForPoints=numberOfGames-NumberOfGamesTie6;
        System.out.println(sumOfPointsOfTeam1+" "+sumOfPointsOfTeam2);
    }
    public List<ScoresList> getScoresList6() {
        return scoresList6;
    }
    public void setScoresList6(List<ScoresList> scoresList6) {
        this.scoresList6 = scoresList6;
    }
    public void passingWinString(String win){
        sendingWinString(win);
    }
    public String sendingWinString(String win){
        return win;
    }
    public String createLeaderBoard(){
        System.out.println("Team name\tW\tL\t+\t-\t");
        for(Object s:scoresList6){
            for(Object t:teamNamesList){

            }
        }

            System.out.println();
//        System.out.println(sendingWinString(win));
//        System.out.println(sumOfPointsOfTeam1+" "+sumOfPointsOfTeam2);
        return "yes";
    }

    public static void main(String[] args) {
        Game6 game6= new Game6();
        game6.addTeam("Sai6");
        game6.addTeam("Sai9");
        game6.recordGameOutcome("Sai6","Sai9",9,6);
        game6.recordGameOutcome("Sai6","Sai9",6,9);
        game6.recordGameOutcome("Sai6","Sai9",6,6);
        game6.recordGameOutcome("Sai6","Sai9",9,9);
        game6.recordGameOutcome("Sai6","Sai9",9,6);
        game6.recordGameOutcome("Sai6","Sai9",6,9);
        game6.createLeaderBoard();
        game6.totalPoints();
        game6.createLeaderBoard();
    }
    class ScoresList{
        private Integer countOfScoreTeam1,CountOfScoreTeam2,numberOfGames,scoreTeam1,scoreTeam2,numberOfGamesTie;
        ScoresList(){}
        ScoresList(Integer countOfScoreTeam1,Integer countOfScoreTeam2,Integer numberOfGames,Integer scoreTeam1,Integer scoreTeam2,Integer numberOfGamesTie){
            this.countOfScoreTeam1=countOfScoreTeam1;
            this.CountOfScoreTeam2=countOfScoreTeam2;
            this.numberOfGames=numberOfGames;
            this.scoreTeam1=scoreTeam1;
            this.scoreTeam2=scoreTeam2;
            this.numberOfGamesTie=numberOfGamesTie;
        }

        public Integer getCountOfScoreTeam1() {
            return countOfScoreTeam1;
        }

        public void setCountOfScoreTeam1(Integer countOfScoreTeam1) {
            this.countOfScoreTeam1 = countOfScoreTeam1;
        }

        public Integer getCountOfScoreTeam2() {
            return CountOfScoreTeam2;
        }

        public void setCountOfScoreTeam2(Integer countOfScoreTeam2) {
            CountOfScoreTeam2 = countOfScoreTeam2;
        }

        public Integer getNumberOfGames() {
            return numberOfGames;
        }

        public void setNumberOfGames(Integer numberOfGames) {
            this.numberOfGames = numberOfGames;
        }

        public Integer getScoreTeam1() {
            return scoreTeam1;
        }

        public void setScoreTeam1(Integer scoreTeam1) {
            this.scoreTeam1 = scoreTeam1;
        }

        public Integer getScoreTeam2() {
            return scoreTeam2;
        }

        public void setScoreTeam2(Integer scoreTeam2) {
            this.scoreTeam2 = scoreTeam2;
        }

        public Integer getNumberOfGamesTie() {
            return numberOfGamesTie;
        }

        public void setNumberOfGamesTie(Integer numberOfGamesTie) {
            this.numberOfGamesTie = numberOfGamesTie;
        }

        @Override
        public String toString() {
            return "ScoresList{" +
                    "countOfScoreTeam1=" + countOfScoreTeam1 +
                    ", CountOfScoreTeam2=" + CountOfScoreTeam2 +
                    ", numberOfGames=" + numberOfGames +
                    ", scoreTeam1=" + scoreTeam1 +
                    ", scoreTeam2=" + scoreTeam2 +
                    ", numberOfGamesTie=" + numberOfGamesTie +
                    '}';
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ScoresList that = (ScoresList) o;
            if (countOfScoreTeam1.equals(that.countOfScoreTeam1) &&
                    CountOfScoreTeam2.equals(that.CountOfScoreTeam2) &&
                    numberOfGames.equals(that.numberOfGames) &&
                    scoreTeam1.equals(that.scoreTeam1) &&
                    scoreTeam2.equals(that.scoreTeam2)){
                return true;
            }
            else
                return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(countOfScoreTeam1, CountOfScoreTeam2, numberOfGames, scoreTeam1, scoreTeam2);
        }
    }
}
