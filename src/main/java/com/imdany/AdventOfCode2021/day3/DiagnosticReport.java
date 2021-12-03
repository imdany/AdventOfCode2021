package com.imdany.AdventOfCode2021.day3;

import java.util.ArrayList;
import java.util.List;

public class DiagnosticReport {

    private long gammaRate = 0;
    private long epsilonRate = 0;

    private long o2 = 0;
    private long co2 = 0;

    private long powerConsumption = 0;
    private long lifeSupport = 0;

    private int numberSize = 0;
    private List<ReportNumber> reportNumberList = new ArrayList<>();

    public DiagnosticReport(List<String> measuresList) {
        // Create Report numbers List
        for (String e: measuresList){
            this.reportNumberList.add(new ReportNumber(e));
        }
        this.numberSize = this.reportNumberList.get(0).getPositions().length;
//        System.out.println("Reports:");
//        System.out.println(reportNumberList);
//        System.out.println("Report number size:" + this.numberSize);
    }

    public void getReportPowerConsumption(){
        System.out.println("Gamma Rate: " + this.gammaRate);
        System.out.println("Epsilon Rate: " + this.epsilonRate);
        System.out.println("Power Cosumption: " + this.powerConsumption);
    }

    public void getReportLifeSupport() {
        System.out.println("O2: " + this.o2);
        System.out.println("CO2: " + this.co2);
        System.out.println("Life Support: " + this.lifeSupport);
    }

    public void processPowerCosumption(){
        char[] gammaBinary = new char[this.numberSize];
        char[] epsilonBinary = new char[this.numberSize];
        for(int i = 0; i<this.numberSize; i++) {
            gammaBinary[i]=getMostCommonBit(this.reportNumberList, i, "");
            epsilonBinary[i]=getLeastCommonBit(this.reportNumberList, i, "");
        }
        this.gammaRate = this.binaryToInt(gammaBinary);
        this.epsilonRate = this.binaryToInt(epsilonBinary);
        this.powerConsumption = this.gammaRate * this.epsilonRate;
    }

    public void processLifeSupport() {
        //Oxigen process
        List<ReportNumber> tmpListO2 = this.reportNumberList;

        int bitPosition = 0;
        while (tmpListO2.size() != 1) {
            char bitCriteria = getBitCriteria(tmpListO2, "O2", bitPosition);
//            System.out.println("Position: " + bitPosition + " Bit Criteria: " + bitCriteria);
            tmpListO2 = filterList(tmpListO2, bitPosition, bitCriteria);
//            System.out.println(tmpListO2);
            bitPosition++;
        }
        char[] o2Binary = tmpListO2.get(0).getPositions();

        //CO2 process
        List<ReportNumber> tmpListCO2 = this.reportNumberList;
        int bitPositionCO2 = 0;
        while (tmpListCO2.size() != 1) {
            char bitCriteria = getBitCriteria(tmpListCO2, "CO2", bitPositionCO2);
            tmpListCO2 = filterList(tmpListCO2, bitPositionCO2, bitCriteria);
//            System.out.println(tmpListCO2);
            bitPositionCO2++;
        }
        char[] co2Binary = tmpListCO2.get(0).getPositions();

        this.o2 = this.binaryToInt(o2Binary);
        this.co2 = this.binaryToInt(co2Binary);

        this.lifeSupport = this.o2 * this.co2;
    }

    private List<ReportNumber> filterList(List<ReportNumber> list, int bitPosition, char bitCriteria) {
        List<ReportNumber> provList = new ArrayList<>();
        for (ReportNumber e: list) {
            if(e.getPosition(bitPosition) == bitCriteria) {
                provList.add(e);
            }
        }
        return provList;
    }

    private char getBitCriteria(List<ReportNumber> list, String type, int position){
        if (type.equals("O2")) {
            return this.getMostCommonBit(list, position, type);
        } else {
            return this.getLeastCommonBit(list, position, type);
        }
    }

    private char getMostCommonBit(List<ReportNumber> list, int position, String type){
        long[] values = new long[]{0L, 0L};

        for (ReportNumber number: list) {
            char i = number.getPosition(position);
            if(i == '0') {
                values[0] = values[0] + 1;
            } else {
                values[1] = values[1] +1;
            }
        }
        if(type.equals("")) {
            return values[0] > values[1] ? '0' : '1';
        } else {
            if(type.equalsIgnoreCase("O2")) {
                if(values[0] == values[1]) {
                    return '1';
                } else {
                    return values[0] > values[1] ? '0' : '1';
                }
            } else {
                return '9';
            }
        }
    }

    private char getLeastCommonBit(List<ReportNumber> list, int position, String type){
        long[] values = new long[]{0L, 0L};

        for (ReportNumber number: list) {
            char i = number.getPosition(position);
            if(i == '0') {
                values[0] = values[0] + 1;
            } else {
                values[1] = values[1] +1;
            }
        }
        if(type.equals("")) {
            return values[0] > values[1] ? '1' : '0';
        } else {
            if(type.equals("CO2")) {
                if(values[0] == values[1]) {
                    return '0';
                } else {
                    return values[0] > values[1] ? '1' : '0';
                }
            } else {
                return '9';
            }
        }

    }

    private int binaryToInt(char[] binaryNumber) {
        return Integer.parseInt(new String(binaryNumber), 2);
    }

}
