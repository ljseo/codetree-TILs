import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        
        int[][] gifts = new int[N][2]; // [가격, 배송비]
        int[] totalCost = new int[N]; // 각 학생의 총 비용
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            gifts[i][0] = Integer.parseInt(st.nextToken()); // 가격
            gifts[i][1] = Integer.parseInt(st.nextToken()); // 배송비
            totalCost[i] = gifts[i][0] + gifts[i][1];
        }
        
        int maxStudents = 0;
        
        // 각 학생에 대해 쿠폰을 사용하는 경우를 시도
        for (int couponIdx = 0; couponIdx < N; couponIdx++) {
            // 쿠폰을 사용한 학생의 비용 (가격 반값 + 배송비)
            int discountedCost = gifts[couponIdx][0] / 2 + gifts[couponIdx][1];
            
            // 나머지 학생들의 총 비용을 리스트에 추가
            List<Integer> otherCosts = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                if (i != couponIdx) {
                    otherCosts.add(totalCost[i]);
                }
            }
            
            // 비용이 적은 순서로 정렬
            Collections.sort(otherCosts);
            
            // 쿠폰 사용한 학생부터 시작
            int budget = B - discountedCost;
            int count = 1; // 쿠폰 사용한 학생
            
            // 예산이 부족하면 이 경우는 불가능
            if (budget < 0) continue;
            
            // 비용이 적은 학생부터 선물 추가
            for (int cost : otherCosts) {
                if (budget >= cost) {
                    budget -= cost;
                    count++;
                } else {
                    break;
                }
            }
            
            maxStudents = Math.max(maxStudents, count);
        }
        
        System.out.println(maxStudents);
    }
}