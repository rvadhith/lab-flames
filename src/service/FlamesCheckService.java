package service;

// Create a class called FlamesCheckService
// FlamesCheckService has a method findFlames to find the flames between two names
// char findFlames(String name1, String name2) takes two strings as arguments
// Your task is to calculate the flames value and return the corresponding character as output 
// You must return only the following values ['f','l','a','m','e','s']
// change the return value at the end of the method corresponding to your return value

public class FlamesCheckService
{
	public char findFlames(String name1,String name2)
	{
		//Getting inputs - name 1 and name 2
		StringBuffer n1 = new StringBuffer(name1);
		StringBuffer n2 = new StringBuffer(name2);
		int name1Length = n1.length();
		int name2Length = n2.length();
		
		//Finding the unique characters in two names
		for(int i=0; i < name1Length; i++){
			char characterInFirstName = n1.charAt(i);
			for(int j=0; j < name2Length; j++){
				char characterInSecondName = n2.charAt(j);
				if(characterInFirstName == characterInSecondName){
					n1.deleteCharAt(i);
					n2.deleteCharAt(j);
					name1Length = n1.length();
					name2Length = n2.length();
					i=0;
					j=0;					
				}
			}

		}
		
		//Finding the FLAMES character
		int uniqueCharacters = (name1Length + name2Length);
		StringBuffer flames = new StringBuffer("flames");
		String flamesSubString = new String();
		  
		for(int i = 0; i < 5; i++){
			int a = -1, x = 0, y = 0;
			for(int j=1; j <= uniqueCharacters; j++){
				a++;
				x++;
				if(a > flames.length()-1){
					if(x == uniqueCharacters){
						flames.deleteCharAt(y);
						flamesSubString = flames.substring(y,flames.length());
						flames.delete(y,flames.length());
						flames.insert(0,flamesSubString);
						break;
					}
					else{ 
						y++;
						if(y == flames.length()){
							y = 0;
						}
	                 }
				}
				else{
					if(x == uniqueCharacters){
						flames.deleteCharAt(a);
						flamesSubString = flames.substring(a,flames.length());
						flames.delete(a,flames.length());
				    	flames.insert(0,flamesSubString);
				    	break;
					}
				}
	    	}
	   	}
		char finalResult = flames.charAt(0);
		return finalResult;
	}	
}