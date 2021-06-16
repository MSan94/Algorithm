/*

��������
- ��Ϳ���� Ȱ���� ���� �˰���
	1. ����Ʈ�� �������� �߶� ����� ũ���� �� �κ� ����Ʈ�� ������.
	2. �� �κ� ����Ʈ�� ��������� �պ� ������ �̿��Ͽ� ����
	3. �� �κ� ����Ʈ�� �ٽ� �ϳ��� ���ĵ� ����Ʈ�� �պ�
	
ex)  49,97,53,5,33,65,62,51	

- split �ܰ�
	1. 49  97  53  5  33  65  62  51
	2. 49,97  5,53  33,65  51,62
	3. 5,49,53,97    33,51,62,65
	4. 5,33,49,51,53,62,65,97

�˰��� ����
- �����Ͱ� ������, �� �ܰ�� �и��ؼ� ������ �� �ִ�.
	1. ���ĵ��� ���� �迭�� ������ �и��ϴ� �ܰ�
	2. �и��� �����͸� �ܰ躰�� ��ġ�� �ܰ�
	
- ����	
	- ���� �迭 ������ �Ѱ��̸� �ش� �� ����
	- �׷��� ������, �迭�� �� ��, �ΰ��� ������
	- leftArr = mergeSplitFunc(��)
	- reightArr = mergeSplitFunc(��)
	- return mergeFunc(leftArr, rightArr)

- ����
	- ArrayList �����
	- leftPoint, rightPoint = 0
	- Case1 : leftList, RightList �Ѵ� ���� ��
		- while(leftList.size() > leftPoint && rightList.size() > rightPoint)
			- ���� leftPoint�� rightPoint�� �̹� leftList �Ǵ� rightList �迭�� �� ��ȸ�ߴٸ�, 
			  �� �ݴ��� �����͸� �״�� �ְ�, �ش� �ε��� 1����
			- if(leftList.get(leftPoint) > rightList.get(rightPoint))
				- mergedList.add(rightList.get(rightPoint));
				- rightPoint += 1;
			- else
				- mergedList.add(leftList.get(leftPoint));
				- leftPoint += 1;
	- Case2 : RightList�� ���� �� : ������ LeftList�� �ִ� �����͸� �״�� mergedList �ڿ� ����
	- Case3 : LeftList�� ���� �� : ������ RightList�� �ִ� �����͸� �״�� mergedList �ڿ� ����

- �˰��� �м�
	- �� �ܰ� ���̱��� ������������� depth��� �ϰ� i�� ����. �� �� �ܰ�� 0
		- �� �ܰ迡 �ִ� �ϳ��� ��� ���� �迭�� ���̴� n/2^i
		- �� �ܰ迡�� 2^i���� ��尡 �ִ�.
	- �� �ܰ��� �� ��� ���� �迭 �����ʹ� �ѹ����� üũ�ǹǷ�, �� �ܰ�� ���� 2^i * n/2^i = O(n) �ð� ���⵵
	- �ܰ�� �׻� log2n�� ��ŭ �������, �ð� ���⵵�� �ᱹ O(log n), 2�� ���� ����̹Ƿ� ����
	- ����, �ܰ躰 �ð����⵵�� O(n) ^ O(log n) = O(n log n)
*/
