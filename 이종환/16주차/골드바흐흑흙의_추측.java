import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ������������_���� {
	static long from,to,target ,MIN, MAX;
	static HashMap<Long,Long> dp = new HashMap<>();
	static ArrayList<Integer> primeN = new ArrayList<>();
	
	
	public static void main(String[] args) throws IOException {
		getInput();
		process();
	}

	private static void process() {
		makePrimeList();
		processDp();
		print();
	}

	private static void print() {
		if(dp.containsKey(target)) {
			System.out.println(dp.get(target));
		}else {
			System.out.println(0);
		}
	}

	private static void processDp() {
		Queue<Long> tempKey = new LinkedList<>();
		Queue<Long> tempVal = new LinkedList<>();
		dp.put(0l, 1l);
		for (int n: primeN) {
			for (long target: dp.keySet()) {
				tempKey.add(target+n);
				// �ٷ� �ݿ� �� ��ø�Ǿ ������ �� ����.
				// �׷��⿡ Ű���� ������� ť�� ���� ��, ���߿� �ѹ��� �ݿ�
				if (dp.containsKey(target+n)) {
					tempVal.add(dp.get(target+n) + dp.get(target));
				}else {
					tempVal.add(dp.get(target));
				}
			}
			
			while(!tempKey.isEmpty()) {
				long key = tempKey.poll();
				long val = tempVal.poll();
				if (dp.containsKey(key)) {
					dp.replace(key, val);
				} else dp.put(key, val);
				
			}
		}
	}

	private static void makePrimeList() {
		for (int t = (int) Math.max(2, from); t <= to; t++) {
			boolean isPrime = true;
			for (int i = 2; i*i <= t; i++) {
				// ��ƮN������ Ȯ���ϸ� �ȴ�.
				if (t%i==0) {
					isPrime = false;
					break;
				}
			}
			
			if (isPrime) primeN.add(t);
		}
		
	}

	private static void getInput() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		from = Integer.parseInt(st.nextToken());
		to = Integer.parseInt(st.nextToken());
		target = Integer.parseInt(st.nextToken());
		
	}
}
