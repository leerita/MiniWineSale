import java.util.Scanner;
public class WineMgr {
	WineSet wine=new WineSet();
	/**��ʼ��
	 * 
	 */
	public void initial(){
		wine.name[0]="ę́";
		wine.name[1]="����Һ";
		wine.name[2]="���";
		wine.name[3]="ɢװ�����׾�";
		wine.madedate[0]="1950-8-10";
		wine.madedate[1]="1959-6-15";
		wine.madedate[2]="1890-9-20";
		wine.madedate[3]="2013-5-10";
		wine.material[0]="������С��";
		wine.material[1]="������������ף�С���";
		wine.material[2]="�㶹��С�󣬴���";
		wine.material[3]="���ף�����";
		wine.state[0]=1;
		wine.state[1]=1;
		wine.state[2]=0;
		wine.state[3]=1;
		wine.prices[0]=2000.00;
		wine.prices[1]=3000.00;
		wine.prices[2]=4000.00;
		wine.prices[3]=1000.00;
		
		
	}
	/**��ʼ�˵�
	 * 
	 */
	public void startMenu(){
		System.out.println("\t\t\t\t��ӭ���������۾�ϵͳ");	
		System.out.println("\t\t\t\t**********************");
		System.out.println("\t\t\t\t\t1,������Ʒ");
		System.out.println("\t\t\t\t\t2,�鿴��Ʒ");
		System.out.println("\t\t\t\t\t3,��Ʒ��װ");
		System.out.println("\t\t\t\t\t4,ɾ����Ʒ");
		System.out.println("\t\t\t\t\t5,ѡ����Ʒ");
		System.out.println("\t\t\t\t\t6,��	  ��");
		System.out.println("\t\t\t\t**********************");
		
		System.out.println("��ѡ��");
		Scanner s=new Scanner(System.in);
		int input=s.nextInt();
		switch(input){
			case 1:
				add();
				break;
			case 2:
				list();
				break;
			case 3:
				decoration();
				break;
			case 4:
				delete();
				break;
			case 5:
				order();
				break;
			case 6:
				System.out.println("ллʹ�ã�����");
				break;
		}
		s.close();
	}
	/**����������
	 * 
	 */
	public void returnMain(){
			System.out.print("����0�������˵���\n");
			Scanner s=new Scanner(System.in);
			int input=s.nextInt();
			if(input == 0){
				startMenu();
			}else{
				System.out.println("���������쳣��ֹ������");
			}
			s.close();
		}
	/**��Ӳ���
	 * 
	 */
	public void add(){
			System.out.println("------>������Ʒ��\n");
			System.out.print("������������Ʒ���ƣ�");
			Scanner s = new Scanner(System.in);
			String input=s.next();
			System.out.print("������������Ʒ�������ڣ�");
			String madeDate=s.next();
			System.out.print("������������Ʒ�۸�");
			double price=s.nextDouble();
			for(int i=0;i<wine.name.length;i++){//ע�����ö������
				if(wine.name[i]==null){
					wine.name[i]=input;
					wine.state[i]=1;
					wine.madedate[i]=madeDate;
					wine.prices[i]=price;
					System.out.println("���' "+input+" ' �ɹ�������");
					break;//ע��ʹ��break;
				}
			}
			System.out.println("*********************");
			returnMain();
			s.close();
		}
	/**��ѯ��Ϣ����
	 * 	
	 */
	public void list(){
			System.out.println("------>��Ʒ��Ϣ��\n");
			System.out.print("���\t\t\t\tƷ��\t\t\t\t״̬\t\t\t\t����ʱ��\t\t\t�۸�\n");
			for(int i=0;i<wine.name.length;i++){
				if(wine.name[i]==null){
					break;
				}else if(wine.state[i]==0){
					System.out.println((i+1)+"\t\t\t\t"+wine.name[i]+"\t\t\t\t�޻�"+"\t\t\t\t"+wine.madedate[i]+"\t\t\t"
				+wine.prices[i]);
				}else if(wine.state[i]==1){
					System.out.println((i+1)+"\t\t\t\t"+wine.name[i]+"\t\t\t\t�л�"+"\t\t\t\t"+wine.madedate[i]+"\t\t\t"
							+wine.prices[i]);
				}
			}
			System.out.println("**********************");
			returnMain();
		}
	/**ѡ���װ
	 * 	
	 * @return
	 */
	public double decoration(){
			double price=0.0;
			//boolean flag=false;
		//	while(!flag){
			System.out.println("------>��Ʒ��װ��\n");
			System.out.println("��װ����\t\t"+"�۸�");
			System.out.println("\tͰװ\t\t"+"��100");
			System.out.println("\t̳װ\t\t"+"��300");
			System.out.print("Ҫѡ���װ��(y/n)");
			Scanner s=new Scanner(System.in);
			String input=s.next();
				if(input.equals("y")){
					System.out.print("��ѡ��Ͱװ��1������̳װ��2��:");
					int choice=s.nextInt();
					if(choice==1){
						price=100.00;
						System.out.println("����ѡ��Ͱװ");
				//		flag=true;
					//	returnMain();
					}else{
						price=300.00;
						System.out.println("����ѡ��̳װ");
				//	flag=true;
						//returnMain();
					}
				}else if(input.equals("n")){
					price=0.0;
					System.out.println("��δѡ���װ");
				//	flag=true;
				}
		//	}
				s.close();
			return price;
			
		}
	/**ɾ������
	 * 	
	 */
	public void delete(){
			boolean flag=false;
			System.out.print("------>ɾ����Ʒ��\n");
			System.out.println("������Ҫɾ���ľ�Ʒ���ƣ�");
			Scanner s=new Scanner(System.in);
			String input=s.next();
			for(int i=0;i<wine.name.length;i++){
				//����Ԫ�أ�ÿ��Ԫ��ǰ��
				if(input.equalsIgnoreCase(wine.name[i]) 
						&& wine.name[i] !=null && wine.state[i]==1 ){
					int j=i;
					while(wine.name[j]!=null){
						wine.name[j]=wine.name[j+1];
						wine.state[j]=wine.state[j+1];
						wine.madedate[j]=wine.madedate[j+1];
						j++;
					}
					//���Ĳ�Ϊ�յ�Ԫ���ÿ�
					wine.name[j]=null;
					//wine.state[j]=0;
					wine.madedate[j]=null;
					System.out.println("ɾ��"+input+"�ɹ�");
					flag=true;
					break;
				}else if(input.equalsIgnoreCase(wine.name[i]) 
						&& wine.name[i] !=null && wine.state[i]==0){
					System.out.println(input+"�ǲ����ڵľ�Ʒ"); 
	      			flag=true;//��λ
	      			break;
				}
			}
			if(!flag){
	      		System.out.println("û���ҵ�ƥ����Ϣ��");
	      	}
	      	System.out.println("**************************");
	      	returnMain(); 	
	      	s.close();
		}
	/**ѡ��
	 * 
	 */
	public void order(){
			
			System.out.print("������Ҫ����ľ�Ʒ���ƣ�\n");
			Scanner s=new Scanner(System.in);
			String input=s.next();
			
					if(input.equals("ɢװ�����׾�")){
						double price=decoration();
						System.out.println("�����빺��������");
						int num=s.nextInt();
						double total=num*(1000+price);
						System.out.println("�ϼƽ���"+total);
				
					}else {
									System.out.println("�����빺��������");
									int num=s.nextInt();
									for(int i=0;i<wine.name.length;i++){
										if(input.equals(wine.name[i])){
											double total=wine.prices[i]*num;
											System.out.println("�ϼƽ���"+total);
										
										}
									}
					}
				
				/*}else{
					System.out.println("��Ҫ����ľ�Ʒ��������򲻴���");
				}*/
					s.close();
			returnMain();
		}
}
