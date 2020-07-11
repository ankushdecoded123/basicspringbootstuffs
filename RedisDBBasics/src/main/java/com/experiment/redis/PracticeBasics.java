/*
 * package com.experiment.redis;
 * 
 * public class PracticeBasics {
 * 
 * public String getRunLengthEncodedStr(String pureString) { StringBuilder
 * runLengthEncodedStr=new StringBuilder(); for (int i = 0; i <
 * pureString.length(); i++) { char tempC = pureString.charAt(i);
 * if(Boolean.TRUE.equals(checkForDuplicateEntry(tempC, runLengthEncodedStr))) {
 * runLengthEncodedStr.append(tempC);
 * runLengthEncodedStr.append(getCounts(pureString, tempC)); }
 * 
 * } return runLengthEncodedStr.toString(); }
 * 
 * private int getCounts(String pureString, char targetChar) { int i=0; for (int
 * j = 0; j < pureString.length(); j++) { if(pureString.charAt(j)==targetChar)
 * i++; } return i; }
 * 
 * private Boolean checkForDuplicateEntry(char targetChar, StringBuilder str) {
 * if(str.length()>0) return
 * (str.toString().contains(String.valueOf(targetChar))) ? Boolean.FALSE :
 * Boolean.TRUE; else return true; }
 * 
 * public static void main(String[] args) { PracticeBasics p = new
 * PracticeBasics();
 * System.err.println(p.getRunLengthEncodedStr("wwwwwaaadexxxxxxx")); } }
 */