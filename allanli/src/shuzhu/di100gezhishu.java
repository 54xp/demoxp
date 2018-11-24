package shuzhu;

public class di100gezhishu {
public static void main(String[] args) {
	for(int i=2;i<=1000;i++){
		for(int k=2;k<=i;k++){
			if(i%k==0&&i!=k){
				break;
			}else if(i%k==0&&i==k){
				System.out.println(i);
			}
		}
	}
	
	}
	}


