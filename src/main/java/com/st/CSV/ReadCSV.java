package com.st.CSV;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReadCSV {
	public List<UserModel> users;
	
	public void getOutput(String path) {
		users = CSVReaderUtils.convertCSVToUserModel(path);
	}
	
	public void printAll() {
		for(UserModel userModel : users)
			System.out.println(userModel);
	}
	
	public static void main(String[] args) {
		 ReadCSV csv = new ReadCSV();
		 csv.getOutput("E:\\Backup\\test.csv");
		// csv.printAll();
		System.out.println(csv.sumOfSalary(csv.users));
		System.out.println(csv.avgOfSalary(csv.users));
		System.out.println(csv.groupByOfCity(csv.users));
		System.out.println(csv.groupByOfGender(csv.users));
		//Map<String, List<UserModel>> 
	}

	public Double sumOfSalary(List<UserModel> users) {
		 //IntSummaryStatistics o = users.stream().collect(Collectors.groupingBy(UserModel::getCity);
		//Map<String, List<UserModel>> user = users.stream().collect(Collectors.groupingBy(UserModel::getCity));
		//System.out.println(user);
		return users.stream().collect(Collectors.summingDouble(UserModel::getSalary));
	}
	/**
	 * 
	 * @param users
	 * @return
	 */
	public Double avgOfSalary(List<UserModel> users)
	{
		return users.stream().collect(Collectors.averagingDouble(UserModel::getSalary));
	}
	public Map<String, List<UserModel>> groupByOfCity(List<UserModel> users)
	{
		return users.stream().collect(Collectors.groupingBy(UserModel::getCity));
	}
	
	public Map<Gender, List<UserModel>> groupByOfGender(List<UserModel> users)
	{
		return users.stream().collect(Collectors.groupingBy(UserModel::getGender));
	}
	

}
