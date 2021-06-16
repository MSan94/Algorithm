package ��������;

import java.util.ArrayList;
import java.util.Arrays;

public class �������ı⺻ {
	public static void main(String[] args) {
		System.out.println(splitFunc(new ArrayList<Integer>(Arrays.asList(8,1,9,5,3,7))));
	}

	// ���� �޼���
	static ArrayList<Integer> splitFunc(ArrayList<Integer> dataList) {
		if (dataList.size() <= 1) {
			return dataList;
		}
		int mid = dataList.size() / 2;
		ArrayList<Integer> leftArr = new ArrayList<Integer>();
		ArrayList<Integer> rightArr = new ArrayList<Integer>();

		leftArr = splitFunc(new ArrayList<Integer>(dataList.subList(0, mid))); // 0���� mid - 1 �ε��� ���� ����迭�� ����
		rightArr = splitFunc(new ArrayList<Integer>(dataList.subList(mid, dataList.size())));
		return mergeFunc(leftArr, rightArr);
	}

	// ���� �޼���
	static ArrayList<Integer> mergeFunc(ArrayList<Integer> leftList, ArrayList<Integer> rightList) {
		ArrayList<Integer> mergedList = new ArrayList<Integer>();
		int leftPoint = 0;
		int rightPoint = 0;
		
		// CASE1 : left/right �� �� ������
		while(leftList.size() > leftPoint && rightList.size() > rightPoint) {
			if(leftList.get(leftPoint) > rightList.get(rightPoint)) {
				mergedList.add(rightList.get(rightPoint));
				rightPoint++;
			}else {
				mergedList.add(leftList.get(leftPoint));
				leftPoint++;
			}
		}
		// CASE2 : right �����Ͱ� ���� ��
		while(leftList.size() > leftPoint) {
			mergedList.add(leftList.get(leftPoint));
			leftPoint++;
		}
		
		
		// CASE3 : left �����Ͱ� ���� ��
		while(rightList.size() > rightPoint) {
			mergedList.add(rightList.get(rightPoint));
			rightPoint++;
		}
		
		return mergedList;
	}
}
