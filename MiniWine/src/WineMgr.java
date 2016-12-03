import java.util.Scanner;
public class WineMgr {
	WineSet wine=new WineSet();
	/**初始化
	 * 
	 */
	public void initial(){
		wine.name[0]="茅台";
		wine.name[1]="五粮液";
		wine.name[2]="洋河";
		wine.name[3]="散装纯粮白酒";
		wine.madedate[0]="1950-8-10";
		wine.madedate[1]="1959-6-15";
		wine.madedate[2]="1890-9-20";
		wine.madedate[3]="2013-5-10";
		wine.material[0]="高粱，小麦";
		wine.material[1]="五谷杂粮，大米，小麦等";
		wine.material[2]="豌豆，小麦，大麦";
		wine.material[3]="玉米，白糖";
		wine.state[0]=1;
		wine.state[1]=1;
		wine.state[2]=0;
		wine.state[3]=1;
		wine.prices[0]=2000.00;
		wine.prices[1]=3000.00;
		wine.prices[2]=4000.00;
		wine.prices[3]=1000.00;
		
		
	}
	/**开始菜单
	 * 
	 */
	public void startMenu(){
		System.out.println("\t\t\t\t欢迎进入迷你售酒系统");	
		System.out.println("\t\t\t\t**********************");
		System.out.println("\t\t\t\t\t1,新增酒品");
		System.out.println("\t\t\t\t\t2,查看酒品");
		System.out.println("\t\t\t\t\t3,酒品包装");
		System.out.println("\t\t\t\t\t4,删除酒品");
		System.out.println("\t\t\t\t\t5,选购酒品");
		System.out.println("\t\t\t\t\t6,退	  出");
		System.out.println("\t\t\t\t**********************");
		
		System.out.println("请选择：");
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
				System.out.println("谢谢使用！！！");
				break;
		}
		s.close();
	}
	/**返回主函数
	 * 
	 */
	public void returnMain(){
			System.out.print("输入0返回主菜单：\n");
			Scanner s=new Scanner(System.in);
			int input=s.nextInt();
			if(input == 0){
				startMenu();
			}else{
				System.out.println("输入有误，异常终止！！！");
			}
			s.close();
		}
	/**添加操作
	 * 
	 */
	public void add(){
			System.out.println("------>新增酒品：\n");
			System.out.print("请输入新增酒品名称：");
			Scanner s = new Scanner(System.in);
			String input=s.next();
			System.out.print("请输入新增酒品生产日期：");
			String madeDate=s.next();
			System.out.print("请输入新增酒品价格：");
			double price=s.nextDouble();
			for(int i=0;i<wine.name.length;i++){//注意利用对象调用
				if(wine.name[i]==null){
					wine.name[i]=input;
					wine.state[i]=1;
					wine.madedate[i]=madeDate;
					wine.prices[i]=price;
					System.out.println("添加' "+input+" ' 成功！！！");
					break;//注意使用break;
				}
			}
			System.out.println("*********************");
			returnMain();
			s.close();
		}
	/**查询信息操作
	 * 	
	 */
	public void list(){
			System.out.println("------>酒品信息：\n");
			System.out.print("序号\t\t\t\t品牌\t\t\t\t状态\t\t\t\t生产时间\t\t\t价格\n");
			for(int i=0;i<wine.name.length;i++){
				if(wine.name[i]==null){
					break;
				}else if(wine.state[i]==0){
					System.out.println((i+1)+"\t\t\t\t"+wine.name[i]+"\t\t\t\t无货"+"\t\t\t\t"+wine.madedate[i]+"\t\t\t"
				+wine.prices[i]);
				}else if(wine.state[i]==1){
					System.out.println((i+1)+"\t\t\t\t"+wine.name[i]+"\t\t\t\t有货"+"\t\t\t\t"+wine.madedate[i]+"\t\t\t"
							+wine.prices[i]);
				}
			}
			System.out.println("**********************");
			returnMain();
		}
	/**选择包装
	 * 	
	 * @return
	 */
	public double decoration(){
			double price=0.0;
			//boolean flag=false;
		//	while(!flag){
			System.out.println("------>酒品包装：\n");
			System.out.println("包装种类\t\t"+"价格");
			System.out.println("\t桶装\t\t"+"￥100");
			System.out.println("\t坛装\t\t"+"￥300");
			System.out.print("要选择包装吗(y/n)");
			Scanner s=new Scanner(System.in);
			String input=s.next();
				if(input.equals("y")){
					System.out.print("请选择桶装（1）或是坛装（2）:");
					int choice=s.nextInt();
					if(choice==1){
						price=100.00;
						System.out.println("您已选择桶装");
				//		flag=true;
					//	returnMain();
					}else{
						price=300.00;
						System.out.println("您已选择坛装");
				//	flag=true;
						//returnMain();
					}
				}else if(input.equals("n")){
					price=0.0;
					System.out.println("您未选择包装");
				//	flag=true;
				}
		//	}
				s.close();
			return price;
			
		}
	/**删除操作
	 * 	
	 */
	public void delete(){
			boolean flag=false;
			System.out.print("------>删除酒品：\n");
			System.out.println("请输入要删除的酒品名称：");
			Scanner s=new Scanner(System.in);
			String input=s.next();
			for(int i=0;i<wine.name.length;i++){
				//查找元素，每个元素前移
				if(input.equalsIgnoreCase(wine.name[i]) 
						&& wine.name[i] !=null && wine.state[i]==1 ){
					int j=i;
					while(wine.name[j]!=null){
						wine.name[j]=wine.name[j+1];
						wine.state[j]=wine.state[j+1];
						wine.madedate[j]=wine.madedate[j+1];
						j++;
					}
					//最后的不为空的元素置空
					wine.name[j]=null;
					//wine.state[j]=0;
					wine.madedate[j]=null;
					System.out.println("删除"+input+"成功");
					flag=true;
					break;
				}else if(input.equalsIgnoreCase(wine.name[i]) 
						&& wine.name[i] !=null && wine.state[i]==0){
					System.out.println(input+"是不存在的酒品"); 
	      			flag=true;//置位
	      			break;
				}
			}
			if(!flag){
	      		System.out.println("没有找到匹配信息！");
	      	}
	      	System.out.println("**************************");
	      	returnMain(); 	
	      	s.close();
		}
	/**选购
	 * 
	 */
	public void order(){
			
			System.out.print("请输入要购买的酒品名称：\n");
			Scanner s=new Scanner(System.in);
			String input=s.next();
			
					if(input.equals("散装纯粮白酒")){
						double price=decoration();
						System.out.println("请输入购买数量：");
						int num=s.nextInt();
						double total=num*(1000+price);
						System.out.println("合计金额：￥"+total);
				
					}else {
									System.out.println("请输入购买数量：");
									int num=s.nextInt();
									for(int i=0;i<wine.name.length;i++){
										if(input.equals(wine.name[i])){
											double total=wine.prices[i]*num;
											System.out.println("合计金额：￥"+total);
										
										}
									}
					}
				
				/*}else{
					System.out.println("所要购买的酒品名称有误或不存在");
				}*/
					s.close();
			returnMain();
		}
}
