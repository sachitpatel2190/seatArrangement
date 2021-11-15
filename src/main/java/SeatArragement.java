import java.util.ArrayList;
import java.util.List;

public class SeatArragement {

    public static void main(String[] args) throws Exception {

       int[][] seatsPattern = {{3,2}, {4,3}, {2,3},{3,4},{2,3}, {3,3}};
       int numberOfPassenger = 30;
       List<int[][]> passengerSeatBlocks  = arrangePassenger(seatsPattern, numberOfPassenger);



       int numberOfRows = 0;
        for(int i=0; i < seatsPattern.length; i++){

            if(numberOfRows < seatsPattern[i][1]){
                numberOfRows = seatsPattern[i][1];
            }
          }
       printSeatArrangement(passengerSeatBlocks, numberOfRows);
    }

    public static List<int[][]> arrangePassenger(int[][] seatPattern, int numberOfPassenger) throws Exception {

        List<int[][]> seatBlocks = new ArrayList<>();
        int passengerIndex = 0;
        int totalNumberOfRowSeat = 0;
        int allowedNumberOfPassenger = 0;

        for(int i=0; i < seatPattern.length; i++){
            seatBlocks.add(new int[seatPattern[i][1]][seatPattern[i][0]]);
            if(totalNumberOfRowSeat < seatPattern[i][1]){
                totalNumberOfRowSeat = seatPattern[i][1];
            }
            allowedNumberOfPassenger = allowedNumberOfPassenger + (seatPattern[i][1] * seatPattern[i][0]);
        }

       if(allowedNumberOfPassenger < numberOfPassenger){
           throw new Exception("Number of Passenger is greater than number of seats");
       }
       passengerIndex = fillAisleSeat(seatBlocks, numberOfPassenger, passengerIndex, totalNumberOfRowSeat);
       passengerIndex =  fillWindowSeat(seatBlocks, numberOfPassenger, passengerIndex, totalNumberOfRowSeat);
       fillMiddleSeat(seatBlocks, numberOfPassenger, passengerIndex, totalNumberOfRowSeat);

       return seatBlocks;
    }


    public static int fillAisleSeat(List<int[][]> listOfSeatBlock, int numberOfPassenger, int passengerIndex, int totalNumberOfRowSeat){

        for(int i =0; i < totalNumberOfRowSeat; i++){
            for(int j=0; j< listOfSeatBlock.size(); j++){
                int[][] seatBlock = listOfSeatBlock.get(j);

                if(i > (seatBlock.length -1)){
                    continue;
                }

                if(numberOfPassenger == passengerIndex ){
                    return passengerIndex;
                }

                if(j == 0){
                    passengerIndex++;
                    seatBlock[i][seatBlock[i].length - 1] = passengerIndex ;

                } else if(j == (listOfSeatBlock.size() - 1)){
                    passengerIndex++;
                    seatBlock[i][0] = passengerIndex ;

                } else {
                    passengerIndex++;
                    seatBlock[i][0] = passengerIndex ;
                    passengerIndex++;
                    seatBlock[i][seatBlock[i].length - 1] = passengerIndex ;
                }
            }
        }
        return passengerIndex;
    }

    public static int fillWindowSeat(List<int[][]> listOfSeatBlock, int numberOfPassenger, int passengerIndex, int totalNumberOfRowSeat){

        for(int i =0; i < totalNumberOfRowSeat; i++){
            for(int j=0; j< listOfSeatBlock.size(); j++){
                int[][] seatBlock = listOfSeatBlock.get(j);

                if(i > (seatBlock.length -1)){
                    continue;
                }

                if(numberOfPassenger == passengerIndex ){
                    return passengerIndex;
                }

                if(j == 0){
                    passengerIndex++;
                    seatBlock[i][0] = passengerIndex ;
                } else if(j == (listOfSeatBlock.size() - 1)){
                    passengerIndex++;
                    seatBlock[i][seatBlock[i].length - 1] = passengerIndex ;
                }
            }
        }
        return passengerIndex;
    }

    public static int fillMiddleSeat(List<int[][]> listOfSeatBlock, int numberOfPassenger, int passengerIndex, int totalNumberOfRowSeat){

        for(int i =0; i < totalNumberOfRowSeat; i++){
            for(int j=0; j< listOfSeatBlock.size(); j++){
                int[][] seatBlock = listOfSeatBlock.get(j);

                if(i > (seatBlock.length -1)){
                    continue;
                }

                if(numberOfPassenger == passengerIndex ){
                    return passengerIndex;
                }

                if(seatBlock[0].length > 1) {
                    for(int k = 1; k < seatBlock[0].length - 1; k++){
                        passengerIndex++;
                        seatBlock[i][k] = passengerIndex;
                    }
                }
            }
        }
        return passengerIndex;
    }

    public static void printSeatArrangement(List<int[][]> listOfSeatBlock, int totalNumberOfRowSeat){

        for(int i =0; i < totalNumberOfRowSeat; i++){
            for(int j=0; j< listOfSeatBlock.size(); j++){
                int[][] seatBlock = listOfSeatBlock.get(j);

                if(i > (seatBlock.length -1)){
                    for(int k=0; k< seatBlock[0].length; k++){
                        System.out.print("  ");
                    }
                    System.out.print("      ");
                    continue;
                }

                for(int k=0; k< seatBlock[i].length; k++){
                    System.out.print( String.format("%02d", seatBlock[i][k]));
                    System.out.print(" ");
                }

                System.out.print("   ");
            }
            System.out.println();
        }

    }
}
