package com.upgrad.patterns.Service;

import com.upgrad.patterns.Constants.SourceType;
import com.upgrad.patterns.Interfaces.IndianDiseaseStat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiseaseCountFacade {

   //create a private object indiaDiseaseStat of type IndiaDiseaseStatFactory
   private IndiaDiseaseStatFactory indiaDiseaseStat;
    @Autowired
    public DiseaseCountFacade(IndiaDiseaseStatFactory indiaDiseaseStat)
    {
        this.indiaDiseaseStat = indiaDiseaseStat;
    }

    
    //create a public method getDiseaseShCount() that has Object as its return type
    	//call the GetInstance method with DiseaseSh as the parameter using the indiaDiseaseStat object created on line 10
    	//Based on the strategy returned, call the specific implementation of the GetActiveCount method
    	//return the response
   
    
    //create a public method getJohnHopkinCount() that has Object as its return type
		//call the GetInstance method with JohnHopkins as the parameter using the indiaDiseaseStat object created on line 10
		//Based on the strategy returned, call the specific implementation of the GetActiveCount method
    	//return the response
    public Object getDiseaseShCount() {
        // Call GetInstance method with DiseaseSh as the parameter using indiaDiseaseStat object
        IndianDiseaseStat strategy = indiaDiseaseStat.GetInstance(SourceType.DiseaseSh);
        // Based on the strategy returned, call the specific implementation of the GetActiveCount method
        return strategy.GetActiveCount();
    }

    public Object getJohnHopkinCount() {
        // Call GetInstance method with JohnHopkins as the parameter using indiaDiseaseStat object
        IndianDiseaseStat strategy = indiaDiseaseStat.GetInstance(SourceType.JohnHopkins);
        // Based on the strategy returned, call the specific implementation of the GetActiveCount method
        return strategy.GetActiveCount();
    }


    public Object getInfectedRatio(String sourceType) throws IllegalArgumentException {
        try {
            Float population = 900000000F;
            SourceType sourceEnum = SourceType.valueOf(sourceType);
            Float active = Float.valueOf(indiaDiseaseStat.GetInstance(sourceEnum).GetActiveCount());
            Float percent = Float.valueOf((active / population));
            return String.format("%.3f", percent * 100);
        }
        catch (Exception e) {
            String message = String.format("Invalid source type specified. Available source type (%s, %s)", SourceType.DiseaseSh, SourceType.JohnHopkins);
            throw new IllegalArgumentException(message);
        }
    }
}