package Fate;

import java.util.ArrayList;
import java.util.Random;

public class keywords {
	public ArrayList<heroic_Spirits> temp;
	heroic_Spirits assignedServant = new heroic_Spirits();
	heroic_Spirits npUser = new heroic_Spirits();
	play action = new play();
	int mast;
	boolean status;
	
	public keywords() {}

	//Including Self
	public void includingSelf(String attribute, String keyword ) {
		mast=0;
		this.temp = new ArrayList<heroic_Spirits>();
		temp.clear();
		switch(attribute) {
		case "Class":{
			for(int i=0; i < holyGrailWar.totalServants().size();i++) {
				if(holyGrailWar.totalServants().get(i).getHg_class() == keyword) {
					assignedServant=(holyGrailWar.totalServants().get(i));
					temp.add(assignedServant);
				}
			}
		}break;
		case"Gender":{
			for(int i=0; i < holyGrailWar.totalServants().size();i++) {
				if(holyGrailWar.totalServants().get(i).getGender() == keyword) {
					assignedServant=(holyGrailWar.totalServants().get(i));
					temp.add(assignedServant);
				}
			}
		}break;
		case"Alignment":{
			for(int i=0; i < holyGrailWar.totalServants().size();i++) {
				if(holyGrailWar.totalServants().get(i).getAlignment() == keyword) {
					assignedServant=(holyGrailWar.totalServants().get(i));
					temp.add(assignedServant);				}
			}	
		}break;
		case"Species":{
			for(int i=0; i < holyGrailWar.totalServants().size();i++) {
				if(holyGrailWar.totalServants().get(i).getSpecies() == keyword) {
					assignedServant=(holyGrailWar.totalServants().get(i));
					temp.add(assignedServant);				}
			}
		}break;
		case"Master":{
			for(int i=0; i < holyGrailWar.totalServants().size();i++) {
				if(holyGrailWar.totalServants().get(i).master == Integer.parseInt(keyword)) {
					assignedServant=(holyGrailWar.totalServants().get(i));
					temp.add(assignedServant);				}
			}
		}break;
		case"Any":{
			for(int i=0; i < holyGrailWar.totalServants().size();i++)
			{
				assignedServant=(holyGrailWar.totalServants().get(i));
				temp.add(assignedServant);}
			}break;
		default:{}
		}
		
		//End of Switch Case
		if(temp.size()<=0) {
			System.out.println("No more enemy servants under that attribute");
			this.status = false;
			}
		
		else {
		this.status = true;
			}
		}
	
	//Excluding Self
	public void excludingSelf(String attribute, String keyword, String servantName) {
		mast=0;
		this.temp = new ArrayList<heroic_Spirits>();
		temp.clear();
		switch(attribute) {
		case "Class":{
			for(int i=0; i < holyGrailWar.totalServants().size();i++) {
				if(holyGrailWar.totalServants().get(i).getHg_class() == keyword) {
					assignedServant=(holyGrailWar.totalServants().get(i));
					temp.add(assignedServant);
				}
			}
		}break;
		case"Gender":{
			for(int i=0; i < holyGrailWar.totalServants().size();i++) {
				if(holyGrailWar.totalServants().get(i).getGender() == keyword) {
					assignedServant=(holyGrailWar.totalServants().get(i));
					temp.add(assignedServant);
				}
			}
		}break;
		case"Axis":{
			for(int i=0; i < holyGrailWar.totalServants().size();i++) {
				if(holyGrailWar.totalServants().get(i).getAxis() == keyword) {
					assignedServant=(holyGrailWar.totalServants().get(i));
					temp.add(assignedServant);				}
			}	
		}break;
		case"Alignment":{
			for(int i=0; i < holyGrailWar.totalServants().size();i++) {
				if(holyGrailWar.totalServants().get(i).getAlignment() == keyword) {
					assignedServant=(holyGrailWar.totalServants().get(i));
					temp.add(assignedServant);				}
			}	
		}break;
		case"Species":{
			for(int i=0; i < holyGrailWar.totalServants().size();i++) {
				if(holyGrailWar.totalServants().get(i).getSpecies() == keyword) {
					assignedServant=(holyGrailWar.totalServants().get(i));
					temp.add(assignedServant);				}
			}
		}break;
		case"Master":{
			if(keyword=="EachMaster") {
				for(int i=0; i < holyGrailWar.totalServants().size();i++) {
					if(holyGrailWar.totalServants().get(i).getName() == servantName) {
						mast=holyGrailWar.totalServants().get(i).master;
					}}
				
				for(int j=0;j<holyGrailWar.masters().size();j++) {
				ArrayList<heroic_Spirits> mT = new ArrayList<heroic_Spirits>();
				for(int i=0; i < holyGrailWar.totalServants().size();i++) {
					if(holyGrailWar.totalServants().get(i).master == holyGrailWar.masters().get(j).masterNumber) {
						if(holyGrailWar.totalServants().get(i).master == mast) {
						}
						else {
						mT.add(holyGrailWar.totalServants().get(i));				
						}
					}
					}
				if(mT.size()<=0) {}
				else {
				Random ran = new Random(); int randomServant;
					randomServant = ran.nextInt(mT.size());
					temp.add(mT.get(randomServant));
					mT.clear();}
				}
				
			}
			else {
			if(keyword=="AnyMaster")
			{	
				for(int i=0; i < holyGrailWar.totalServants().size();i++) {
					if(holyGrailWar.totalServants().get(i).getName() == servantName) {
						mast=holyGrailWar.totalServants().get(i).master;
					}}
				
				Random ran = new Random();
				int randomMaster=mast;
				while(randomMaster==mast || randomMaster==0) {
					randomMaster = ran.nextInt(holyGrailWar.masters().size());
				}
				System.out.println("Random Master: "+randomMaster);
				for(int i=0; i < holyGrailWar.totalServants().size();i++) {
				if(randomMaster == holyGrailWar.totalServants().get(i).master) {
					assignedServant=(holyGrailWar.totalServants().get(i));
					temp.add(assignedServant);	
					}
				}
			}
			else {
			for(int i=0; i < holyGrailWar.totalServants().size();i++) {
				if(holyGrailWar.totalServants().get(i).master == Integer.parseInt(keyword)) {
					assignedServant=(holyGrailWar.totalServants().get(i));
					temp.add(assignedServant);				}}}}
		}break;
		case"Any":{
			for(int i=0; i < holyGrailWar.totalServants().size();i++)
			{
				assignedServant=(holyGrailWar.totalServants().get(i));
				temp.add(assignedServant);}
			}break;
		case"Extra":{
			for(int i=0; i < holyGrailWar.totalServants().size();i++)
			{
				for(int h=0;h<holyGrailWar.totalServants().get(i).extraTraits.size();h++) {
					if(holyGrailWar.totalServants().get(i).extraTraits.get(h) == keyword) {
						assignedServant=(holyGrailWar.totalServants().get(i));
						temp.add(assignedServant);
				}
			}
			}
			}break;
		default:{}
		}
		
		removeSelf(servantName);
		removeTeammates(mast);
		}

	
	//Methods
	public void servantChoice() {
		if(temp.size()<=0) {
			System.out.println("No more enemy servants under that attribute");
			this.status = false;
			}
		
		else {
		this.status = true;
			}
		if(this.status == true) {
		Random rando = new Random();
		int randomAllignedServant = rando.nextInt(temp.size());
		assignedServant = temp.get(randomAllignedServant);
		temp.remove(randomAllignedServant);
		System.out.println("Servant Choice: " + assignedServant.getName());
		
		}else {}
		}
	
	public void removeServant(String rs) {
		removeSelf(rs);
		if(temp.size()<=0) {
			this.status = false;
			}
		
		else {
		this.status = true;
			}
		}
	
	public void clearList() {
		int size = temp.size() - 1;
		for (int i = size; i>=0; i--)		{
			temp.remove(i);
		}
	}

	public boolean status() {
		return this.status;
	}
	
	public void selfAndTeammates(int mast) {
		this.temp = new ArrayList<heroic_Spirits>();
		temp.clear();
		for(int i=0; i < holyGrailWar.totalServants().size();i++)
		{
			if(holyGrailWar.totalServants().get(i).master==mast) {
				assignedServant=(holyGrailWar.totalServants().get(i));
				temp.add(assignedServant);
			}
		}
	}
	
	public void removeType(String attribute) {
		for(int i=0;i<temp.size();i++) {
			for(int u=0; u<temp.get(i).extraTraits.size();u++) {
				if(temp.get(i).extraTraits.get(u)==attribute) {
					temp.remove(i);
				}
			}
		}
	}
	
	public void removeTeammates(int mas) {
		for (int i=0;i<temp.size();i++) {
			if(temp.get(i).master==mas)
			{
				System.out.println("NP USER TEAMMMATE REMOVED: "+temp.get(i).getName());
				temp.remove(i);
			}
			else {}
		}
	}
	
	public void removeSelf(String off)
	{
		for(int i=0; i < temp.size(); i++) {
			if(temp.get(i).getName() == off) {
				mast = temp.get(i).master;
				System.out.println("NP USER REMOVED: "+temp.get(i).getName());
				temp.remove(temp.get(i));
				}
			else {}
			}
	}
}
