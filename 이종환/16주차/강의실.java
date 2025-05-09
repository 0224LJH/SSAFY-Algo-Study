import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ���ǽ� {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int len = Integer.parseInt(st.nextToken());
		int telCnt = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[len+1];
		int[] diff = new int[len];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i<= len ;i++) arr[i] = Integer.parseInt(st.nextToken());
		
		// �� ����. �̶� ���� ���Ҷ��� ���Ǹ� ���� ���� �ϳ� �߰�
		Arrays.sort(arr);;
		
		//���� ���ϰ� ����
		for (int i = 0; i < len; i++) diff[i] = arr[i+1] - arr[i];
		Arrays.sort(diff);
		
		// �������� �ڷ���Ʈ ������ŭ ���� ��!
		int ans = arr[len];
		for (int i = 1; i<= telCnt; i++) ans -= diff[len-i];
		
		System.out.println(ans);
		
	}
}
