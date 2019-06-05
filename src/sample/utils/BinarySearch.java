package sample.utils;

import java.util.ArrayList;

public class BinarySearch {

    public static int binarySearch(ArrayList<Integer> arrayList,int element){
        int mid=arrayList.size()/2;
        if(element==arrayList.get(mid)){
            return mid;
        }
        int start=0;
        int end=arrayList.size()-1;
        while (start<=end){
            mid= (end-start)/2 + start;
            if(element<arrayList.get(mid)){
                end=mid-1;
            }
            else if(element>arrayList.get(mid)){
                start=mid+1;
            }
            else{
                break;
            }
        }
        if (arrayList.get(mid)>=element||mid==arrayList.size()-1){
            return mid;
        }
        else{
            return mid+1;
        }
    }
}
