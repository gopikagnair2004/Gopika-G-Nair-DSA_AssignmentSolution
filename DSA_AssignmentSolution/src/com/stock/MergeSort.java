package com.stock;

public class MergeSort  {
	

	void merge(Stockers[] arr, int left, int mid, int right) {
		
		int n1 = mid - left + 1;
		int n2 = right - mid;

		Stockers leftArray[] = new Stockers[n1];
		Stockers rightArray[] = new Stockers[n2];

		for (int i = 0; i < n1; ++i)
			leftArray[i] = arr[left + i];
		for (int j = 0; j < n2; ++j)
			rightArray[j] = arr[mid + 1 + j];

		int i = 0, j = 0;

		int k = left;
		while (i < n1 && j < n2) {
			if (leftArray[i].sharePrice <= rightArray[j].sharePrice) {
				arr[k] = leftArray[i];
				i++;
			} else {
				arr[k] = rightArray[j];
				j++;
			}
			k++;
		}

		while (i < n1) {
			arr[k] = leftArray[i];
			i++;
			k++;
		}

		while (j < n2) {
			arr[k] = rightArray[j];
			j++;
			k++;
		}
	}

	public void mergesort(Stockers[] company, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;

			mergesort(company, left, mid);
			mergesort(company, mid + 1, right);
			merge(company, left, mid, right);
		}
	}
}
