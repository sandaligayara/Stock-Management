import java.util.*;

class Main{
	private static Scanner input=new Scanner(System.in);
	private static String cred[]={"Danuja","1234"};
	private static String [][] idName = new String[0][2];
	private static String [][] ItemName = new String[0][6];
	private static String[] item = new String[0];
	private static int j = 0;	
	private static int sup=0;
	private static int ItC=0;
	private static int ItemNo=0;
	private static boolean flag;

	public static void main(String args[]){
		loginPage();
	}

	private final static void clearConsole() {
		final String os = System.getProperty("os.name");
			try {
				if (os.equals("Linux")) {
				System.out.print("\033\143");
				} else if (os.equals("Windows")) {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
				} else {
				System.out.print("\033[H\033[2J");
				System.out.flush();
				}
			} catch (final Exception e) {
			System.err.println(e.getMessage());
			}
	}

	public static void loginPage(){
		
		String welcomeText = "login page";
        int boxWidth = 98;
        int padding = (boxWidth - welcomeText.length() - 2) / 2;

        System.out.println("+-----------------------------------------------------------------------------------------------+");
        System.out.printf("|%-" + padding + "s%S%-" + padding + "s|%n", "", welcomeText, "");
        System.out.println("+-----------------------------------------------------------------------------------------------+");

		flag = false;
        do {
            System.out.printf("%n %-10s ","Username:");
            String name = input.next();
            if (name.equals(cred[0])){
                do {
                    System.out.printf("%n %-10s ","Password:");
                    String pw = input.next();
                    if (pw.equals(cred[1])){
                        flag = true;
                        clearConsole();
                        HomePage();
                    }else {
                        System.out.printf(" %-10s %n","Password is invalid! Please try again with valid password....");
                        continue ;
                    }
                }while (!flag);
            }else System.out.printf(" %-10s %n %n","Username is invalid! Please try again with valid username....");
        }while (!flag);
    }
	
	public static void HomePage(){
		String welcomeText = " WELCOME TO IJSE STOCK MANAGEMENT SYSTEM   ";
			int boxWidth = 98;
			int padding = (boxWidth - welcomeText.length() - 2) / 2;

			System.out.println("+-----------------------------------------------------------------------------------------------+");
			System.out.printf("|%-" + padding + "s%S%-" + padding + "s|%n", "", welcomeText, "");
			System.out.println("+-----------------------------------------------------------------------------------------------+");
			System.out.println();
		
			System.out.print("[1] Change the Credentials");
			System.out.println("\t\t[2] Supplier Manage");
			System.out.print("[3] Stock Manage");
			System.out.println("\t\t\t[4] log out");
			System.out.println("[5] Exit the system");
			System.out.println();
		
			System.out.print("Enter an option to continue > ");
			int num= input.nextInt();
			
			if(num==1){
				clearConsole();
				changeCredential();
			} else if(num==2){
				clearConsole();
				supplierManage();	
			}else if(num==4){
				clearConsole();
				loginPage();
			}else if(num==3){
				clearConsole();
				StockManage();	
			}else System.exit(0);
	}
	
	public static void changeCredential(){
			
		String welcomeText = "credentianal manage";
        int boxWidth = 98;
        int padding = (boxWidth - welcomeText.length() - 2) / 2; // Calculate the padding on both sides

        System.out.println("+-----------------------------------------------------------------------------------------------+");
        System.out.printf("|%-" + padding + "s%S%-" + padding + "s|%n", "", welcomeText, "");
        System.out.println("+-----------------------------------------------------------------------------------------------+");

        flag = false;
        L1:
        do {
            System.out.printf("%-10s","Please enter the user name to verify it's you: ");
            String name = input.next();
            if (name.equals(cred[0])){
                System.out.printf("%n %s","Hey "+cred[0]);
                L2:
                do {
                    System.out.printf("%n %s","Enter your current Password : ");
                    String pw = input.next();
                    if (pw.equals(cred[1])){
                        flag = true;
                        System.out.printf("%n %s","Enter Your new password : ");
                        String password = input.next();
                        cred[1]=password ;
                        System.out.print("Password changed Successfully! Do you want to go home page. (Y or N): ");
                        String YOrN = input.next();
                        if (YOrN.equals("Y")){
                            clearConsole();
                            HomePage();
                        }else return;
                    }else {
                        System.out.print("Incorrect password. try again!");
                        continue ;
                    }
                }while(!flag);
            }else {
                System.out.println("Invalid User name. try again!");
                continue ;
            }
        }while (!flag);
    }
			
	
			
	public static void supplierManage(){
		String welcomeText = " SUPPLIER MANAGE ";
			int boxWidth = 98;

			int padding = (boxWidth - welcomeText.length() - 2) / 2;

			System.out.println("+-----------------------------------------------------------------------------------------------+");
			System.out.printf("|%-" + padding + "s%S%-" + padding + "s|%n", "", welcomeText, "");
			System.out.println("+-----------------------------------------------------------------------------------------------+");
			System.out.println();
		
			System.out.print("[1] Add Supplier");
			System.out.println("\t\t[2] Update Supplier");
			System.out.print("[3] Delete Supplier");
			System.out.println("\t\t[4] View Suppliers");
			System.out.print("[5] Search Supplier");
			System.out.print("\t\t[6] Home page ");
			System.out.println();
				
			System.out.println();
			System.out.print("Enter an option to continue > ");
			int num= input.nextInt();
			System.out.println();
				
			if (num==1){
				clearConsole();
				AddSupplier();
			}else if (num==2){
				clearConsole();
				UpdateSupplier();
			}else if(num==3){
				clearConsole();
				deleteSupplier();
			}else if(num==4){
				clearConsole();
				ViewSuppliers();
			}else if(num==5){
				clearConsole();
				SearchSuppliers();
			}else{
				clearConsole();
				HomePage();
			}
	}

	public static void AddSupplier(){
		String welcomeText = "add suplier";
		int boxWidth = 98;

		int padding = (boxWidth - welcomeText.length() - 2) / 2;

		System.out.println("+-----------------------------------------------------------------------------------------------+");
		System.out.printf("|%-" + padding + "s%S%-" + padding + "s|%n", "", welcomeText, "");
		System.out.println("+-----------------------------------------------------------------------------------------------+");

		String YOrN = "Y";
		L1:
		do {
			flag = false;
			System.out.print("\nSupplier Id: ");
			String id = input.next();

			for (int i = 0 ; i < idName.length ; i++){
				if (id.equals(idName[i][0])){
					flag = true;
				}
			}
			if (!flag){
				idName = grow(idName,2);
				idName[sup][0] = id;

				System.out.print("Supplier name: ");
				String name = input.next();
				idName[sup][1] = name;
				sup++;
			
				System.out.print("Added Successfully... Do you want to add another Supplier (Y or N) : ");
				YOrN = input.next();
				if (YOrN.equals("Y")){
					clearConsole();
					AddSupplier();
				}else {
					clearConsole();
					supplierManage();	
				}
			}else{
				System.out.println("Already exists. try another supplier id! ");
				continue;
			}
		}while (!YOrN.equals("N"));
	}

	public static String[][] grow(String[][] idName,int length){
		String[][] idN = new String[idName.length + 1][length];
			for (int i = 0; i < idName.length; i++) {
				for (int j = 0; j < idName[i].length; j++){
				idN[i][0] = idName[i][0];
				idN[i][1] = idName[i][1];
				}
			}
			return idN;
	}		
			
	public static void UpdateSupplier(){
		
		String welcomeText = "Update Suplier";
		int boxWidth = 98;
		int padding = (boxWidth - welcomeText.length() - 2) / 2;

		System.out.println("+-----------------------------------------------------------------------------------------------+");
		System.out.printf("|%-" + padding + "s%S%-" + padding + "s|%n", "", welcomeText, "");
		System.out.println("+-----------------------------------------------------------------------------------------------+");

		String op="Y";
		L1:
		do{
			flag = false;
			System.out.print("\nSupplier Id: ");
			String id=input.next();
			
			for (int i = 0 ; i < idName.length ; i++){
				if (id.equals(idName[i][0])){					flag = true;
					System.out.println("Supplier name :"+idName[i][1]);
					
					System.out.print("\nEnter the new Supplier name : ");
					String newName=input.next();
					idName[i][1]=newName;
					
					System.out.print("Update successfully ! "+"Do you want to update another supplier ?(Y/N)");
						op=input.next();
						if(op.equals("Y")){
							clearConsole();
							UpdateSupplier();
						}else{
							clearConsole();
							supplierManage();
						}
				}
			}
			if (!flag){
				System.out.println("Can't find supplier id. Try Again ");
				 continue L1;
			}
			
		}while(op!="N");
	}
	
	public static void deleteSupplier() {
		String welcomeText = "delete Supplier";
		int boxWidth = 98;
		int padding = (boxWidth - welcomeText.length() - 2) / 2;

		System.out.println("+-----------------------------------------------------------------------------------------------+");
		System.out.printf("|%-" + padding + "s%S%-" + padding + "s|%n", "", welcomeText, "");
		System.out.println("+-----------------------------------------------------------------------------------------------+");

		String YOrN = "null";
		if (idName.length == 0) {
			System.out.print("No suppliers! Do you want to go to the supplier management page (Y or N): ");
			YOrN = input.next();
			if (YOrN.equals("Y")) {
				clearConsole();
				supplierManage();
			} else {
				return;
			}
		}
		flag = false;
		do {
			System.out.print("\n\n\nSupplier id:");
			String name = input.next();
			int temp = -1;
			for (int i = 0; i < idName.length; i++) {
				for (int j = 0; j < idName[i].length; j++) {
					if (name.equals(idName[i][0])) {
						flag = true;
						temp = i;
						break;
					}
				}
			}

			if (flag) {
				if (temp != -1) {
					String[][] ar = new String[idName.length - 1][2];

					int newIndex = 0;
					for (int i = 0; i < idName.length; i++) {
						if (i != temp) {
							ar[newIndex][0] = idName[i][0];
							ar[newIndex][1] = idName[i][1];
							newIndex++;
						}
					}
					idName = ar;
					sup = sup - 1;
				}
				System.out.print("Delete Successfully! Do you want to delete another (Y or N)");
				YOrN = input.next();
				if (YOrN.equals("Y")) {
					clearConsole();
					deleteSupplier();
				} else if (YOrN.equals("N")) {
					clearConsole();
					supplierManage();
				} else {
					break;
				}
			} else {
				System.out.print("Can't find supplier. Try Again...");
			}
		} while (!YOrN.equals("N"));
	}

	public static void ViewSuppliers(){
		
		String welcomeText = "view suplier";
		int boxWidth = 98;

		int padding = (boxWidth - welcomeText.length() - 2) / 2;

		System.out.println("+-----------------------------------------------------------------------------------------------+");
		System.out.printf("|%-" + padding + "s%S%-" + padding + "s|%n", "", welcomeText, "");
		System.out.println("+-----------------------------------------------------------------------------------------------+"); 
		System.out.println();
		
		if (idName.length == 0){
			System.out.printf("%n %s","No suppliers! Do you want to go supplier manage page (Y or N): ");
			String YOrN = input.next();
			if (YOrN.equals("Y")){
				clearConsole();
				supplierManage();
			}else return;
		}
		
		System.out.printf("--------------------------------%n");
		System.out.printf("| %-10S | %-10S  |%n", "supplier id", "supplier name");
		System.out.printf("--------------------------------%n");

		for (int i = 0; i < idName.length; i++) {
			System.out.printf("| %-10S  | %-10S     |%n", idName[i][0],idName[i][1]);
			System.out.printf("--------------------------------%n");
		}
		System.out.print("Do you want to go Supplier Manage page (Y or N): ");
		String YOrN = input.next();
		if (YOrN.equals("Y")){
			clearConsole();
			supplierManage();
		}else return;
	}
	
	public static void SearchSuppliers(){
		String welcomeText = "SearchSuppliers";
        int boxWidth = 98;
        int padding = (boxWidth - welcomeText.length() - 2) / 2;

        System.out.println("+-----------------------------------------------------------------------------------------------+");
        System.out.printf("|%-" + padding + "s%S%-" + padding + "s|%n", "", welcomeText, "");
        System.out.println("+-----------------------------------------------------------------------------------------------+");
        System.out.println();
        
		String op="Y";
		L1:
		do{
			flag=false;
			
			System.out.print("\nSupplier ID : ");
			String id=input.next();
			
			for (int i = 0; i < idName.length; i++){
				if(id.equals(idName[i][0])){
					flag=true;
					System.out.println("Supplier name :"+idName[i][1]);
				
					System.out.print("find successfully !Do you want to find another ? (Y/N) :");
					op=input.next();
						if(op.equals("Y")){
							clearConsole();
							SearchSuppliers();
						}else{
							clearConsole();
							supplierManage();
						}
				}
			}
			if(!flag){
				System.out.println("Can't find supplier id. try again");
				continue;
			}
		}while(op!="N");
	}
		
	public static void  StockManage(){
		String welcomeText = " Stock Management ";
			int boxWidth = 98;

			int padding = (boxWidth - welcomeText.length() - 2) / 2;

			System.out.println("+-----------------------------------------------------------------------------------------------+");
			System.out.printf("|%-" + padding + "s%S%-" + padding + "s|%n", "", welcomeText, "");
			System.out.println("+-----------------------------------------------------------------------------------------------+");
			System.out.println();
		
			System.out.print("[1] Manage Item Categories");
			System.out.println("\t\t[2] Add Item");
			System.out.print("[3] Get Items supplier wise");
			System.out.println("\t\t[4] View Item");
			System.out.print("[5] Rank Items per Unit Price");
			System.out.print("\t\t[6] Home page ");
			System.out.println();
				
			System.out.println();
			System.out.print("Enter an option to continue > ");
			int num= input.nextInt();
			System.out.println();
			
			if (num==1){
				clearConsole();
				ManageItemCategories();
			} else if(num==2){
				clearConsole();
				AddItem();
			}else if(num==3){
				clearConsole();
				GetItemsSupplierWise();
			}else if(num==4){
				clearConsole();
				viewItems();
			}else if(num==5){
				clearConsole();
				RankedUnitPrice();
			}else{
				clearConsole();
				HomePage();
				}
	}
		
	public static void ManageItemCategories(){
		String welcomeText = " Manage Item Categories ";
			int boxWidth = 98;

			int padding = (boxWidth - welcomeText.length() - 2) / 2;

			System.out.println("+-----------------------------------------------------------------------------------------------+");
			System.out.printf("|%-" + padding + "s%S%-" + padding + "s|%n", "", welcomeText, "");
			System.out.println("+-----------------------------------------------------------------------------------------------+");
			System.out.println();
		
			System.out.print("[1] Add New Category");
			System.out.println("\t\t[2] Delete Item Category");
			System.out.print("[3] Update Item Category ");
			System.out.println("\t[4] Stock Management");
			System.out.println();
				
			System.out.println();
			System.out.print("Enter an option to continue > ");
			int num= input.nextInt();
			System.out.println();
			
				if (num==1){
					clearConsole();
					AddNewCategory();
				}else if(num==2){
					clearConsole();
					DeleteItemCategory();
				}else if(num==3){
					clearConsole();
					UpdateItemCategory();
				}else{
					clearConsole();
					StockManage();
				}	
	}

	public static void AddNewCategory(){
		String welcomeText = "Add Item Category ";
		int boxWidth = 98;
		int padding = (boxWidth - welcomeText.length() - 2) / 2;

		System.out.println("+-----------------------------------------------------------------------------------------------+");
		System.out.printf("|%-" + padding + "s%S%-" + padding + "s|%n", "", welcomeText, "");
		System.out.println("+-----------------------------------------------------------------------------------------------+");
		
		String YOrN = "Y";
		L1:
		do {
			flag = false;						
			System.out.print("Enter the new Item Category : ");
			String name=input.next();
			
			for (int i = 0 ; i < item.length; i++){
				if (name.equals(item[i])){
					flag = true;
				}
			}
			if (!flag){
				item= grow();
				item [ItC]= name;
				ItC++;
				System.out.print("Added Successfully... Do you want to add another Category (Y or N) : ");
				YOrN = input.next();
				if (YOrN.equals("Y")){
					clearConsole();
					AddNewCategory();
					}else{
					clearConsole();
					ManageItemCategories();
					}
			}else System.out.println("Already exists. try another item Category! ");
		}while(!YOrN.equals("N"));
	}

	public static String[] grow(){
		String[] itemNew= new String[item.length + 1];
			for (int i = 0; i < item.length; i++) {
				itemNew[i] = item[i];
			}
			return itemNew;
	}		
			
	public static void DeleteItemCategory(){
		String welcomeText = "Delete Item Category";
		int boxWidth = 98;
		int padding = (boxWidth - welcomeText.length() - 2) / 2;

		System.out.println("+-----------------------------------------------------------------------------------------------+");
		System.out.printf("|%-" + padding + "s%S%-" + padding + "s|%n", "", welcomeText, "");
		System.out.println("+-----------------------------------------------------------------------------------------------+");

		String YOrN = "null";
		
		do {
			 flag = false;
			System.out.print("\n\nItem Category :");
			String name = input.next();
			int temp = -1;
			for (int i = 0; i < item.length; i++) {
				if (name.equals(item[i])) {
					flag = true;
					temp = i;
					break;
				}
			}
			if (flag) {
				if (temp != -1) {
					String[] ar = new String[item.length - 1];

					int newIndex = 0;
					for (int i = 0; i < idName.length; i++) {
						if (i != temp) {
							ar[newIndex] = item[i];
							ar[newIndex] = item[i];
							newIndex++;
						}
					}
					item= ar;
					ItC = ItC - 1;
				}
				System.out.print( "Delete Successfully! Do you want to delete another item category (Y or N) :");
				YOrN = input.next();
				if (YOrN.equals("Y")) {
					clearConsole();
					DeleteItemCategory();
				} else if (YOrN.equals("N")) {
					clearConsole();
					ManageItemCategories();
				} else {
					break;
				}
			} else {
				System.out.print("Can't find item category. Try Again...");
				continue;
			}
		} while (!YOrN.equals("Y"));
	}

	public static void UpdateItemCategory(){
		String welcomeText = "Update Item Category";
		int boxWidth = 98;
		int padding = (boxWidth - welcomeText.length() - 2) / 2;

		System.out.println("+-----------------------------------------------------------------------------------------------+");
		System.out.printf("|%-" + padding + "s%S%-" + padding + "s|%n", "", welcomeText, "");
		System.out.println("+-----------------------------------------------------------------------------------------------+");

		String option="Y";	
		L1:
		do{
			flag=false;
			System.out.print("\nEnter item category : ");	
			String name=input.next();
			for (int i = 0; i < item.length; i++){
				if(item[i].equals(name)){
					flag=true;			
					System.out.print("Enter new category : ");
					String nwname=input.next();
					item[i]=nwname;
					System.out.print("updated Successfully ! Do you want upadte another item ? (Y/N) :");
					option=input.next();
					if(option.equals("Y")){
						clearConsole();
						 UpdateItemCategory();
					}else {
					clearConsole();
					ManageItemCategories();	
					}
				}
			}
			if(!flag){
				System.out.println("can't find item.try again!");	
				continue L1;
			}		
		}while(option!="N");
	}

	public static void AddItem(){
		String welcomeText = "Add item";
		int boxWidth = 98;
		int padding = (boxWidth - welcomeText.length() - 2) / 2;
		
		System.out.println("+-----------------------------------------------------------------------------------------------+");
		System.out.printf("|%-" + padding + "s%S%-" + padding + "s|%n", "", welcomeText, "");
		System.out.println("+-----------------------------------------------------------------------------------------------+");
		
		String op="NULL";
		if(ItC==0){
			System.out.print("OOPS! It seems that you don't have any item categories in the system.\n Do you want to add a new item category ? (Y/N) : ");
			op=input.next();
			if(op.equals("Y")){
				clearConsole();
				AddNewCategory();
				}
		}
			
		if(sup==0){
				System.out.print("OOPS! It seems that you don' have any suppliers in the system.\n Do you want to add a new supplier ? (Y/N) : ");
				op=input.next();
				if(op.equals("Y")){
					clearConsole();
					AddSupplier();
				}else{
					AddItem();
				}
		}

		L1:
		do{
			flag = false;
			System.out.print("Item code : ");
			String code=input.next();
			
			for (int i = 0; i< ItemName.length; i++){
				if(ItemName[i][0].equals(code)){
					flag=true;
					System.out.println("Item code already added. Please try another item code!");
					continue L1;
				}
			}
			
			if(!flag){
				ItemName=GrowItemName();
				ItemName[ItemNo][0]=code;
			
				System.out.println("Suppliers List :");
				
				String column1 = "# ";
				String column2 = "Supplier Id ";
				String column3 = "Supplier Name ";

				boxWidth = 30;
				int boxWidth2 = 29;
				int boxWidth3=28;
				int padding1 = (boxWidth - column1.length() - 2) / 2;
				int padding2 = (boxWidth2 - column2.length() - 2) / 2;
				int padding3 = (boxWidth3 - column3.length() - 2) / 2;

				System.out.println("+-------------------------------------------------------------------------------+");
				System.out.printf("|%-" + padding1 + "s%S%-" + padding1 + "s|\b", "", column1, "");
				System.out.printf("|%-" + padding2 + "s%S%-" + padding2 + "s|", "", column2, "");
				System.out.printf("%-" + padding3 + "s%S%-" + padding3 + "s|%n", "", column3, "");
				System.out.println("+-------------------------------------------------------------------------------+");
				
				flag = false;
				int i = 0;
				do {
					column1 = ((i+1)+"");
					column2 = idName[i][0];
					column3 = idName[i][1];

					boxWidth = 30;
					boxWidth2 = 29;
					boxWidth3=28;

					padding1 = (boxWidth - column1.length() - 2) / 2;
					padding2 = (boxWidth2 - column2.length() - 2) / 2;
					padding3 = (boxWidth3 - column3.length() - 2) / 2;
				  
					System.out.printf("|%-" + padding1 + "s%s%-" + padding1 + "s|\b", "", column1, "");
					System.out.printf("|%-" + padding2 + "s%s%-" + padding2 + "s|", "", column2, "");
					System.out.printf("%-" + padding3 + "s%s%-" + padding3 + "s|%n", "", column3, "");            
					if (i < idName.length - 1) i++;
						else flag = true;
				}while (!flag);

					System.out.println("+-------------------------------------------------------------------------------+");

					System.out.print("\nEnter the supplier number : ");
					int ID=input.nextInt();
					ItemName[ItemNo][1]=idName[ID-1][0];
				
					column1 = "# ";
					column2 = "category name ";

					boxWidth = 30;
					boxWidth2 = 28;
					
					padding1 = (boxWidth - column1.length() - 2) / 2;
					padding2 = (boxWidth2 - column2.length() - 2) / 2;
					
					System.out.println("+-----------------------------------------------------+");
					System.out.printf("|%-" + padding1 + "s%S%-" + padding1 + "s|", "", column1, "");
					System.out.printf("%-" + padding2 + "s%S%-" + padding2 + "s|%n", "", column2, "");
					System.out.println("+-----------------------------------------------------+");

					flag = false;
					int k = 0;
					do {
						column1 = (k+1)+"";
						column2 = item[k];

						boxWidth = 29;
						boxWidth2 = 28;

						padding1 = (boxWidth - column1.length() - 2) / 2;
						padding2 = (boxWidth2 - column2.length() - 2) / 2;

						System.out.printf("|%-" + padding1 + "s%s%-" + padding1 + "s|", "", column1, "");
						System.out.printf("%-" + padding2 + "s%s%-" + padding2 + "s|%n", "", column2, "");
						if (k < item.length - 1) k++;
						else flag = true;
					}while (!flag);
		
					System.out.println("+-----------------------------------------------------+");
					System.out.print("\nEnter the category number : ");
					int num=input.nextInt();
					ItemName[ItemNo][2] = item[num-1];
					
					System.out.print("Descripton : ");
					ItemName [ItemNo][3]=input.next();
					
					System.out.print("Unit Price : ");
					ItemName [ItemNo][4]=input.next();
					
					System.out.print("Qty On Hand : ");
					ItemName [ItemNo][5]=input.next();
					ItemNo++;
					System.out.print("Added successfully! Do you want another Item(Y/N)? ");
					
					op=input.next();
					if(op.equals("Y")){
						clearConsole();
						AddItem();
					}else{
						clearConsole();
						StockManage();
					}
			}else break;
		}while(!op.equals("N"));
	}
	
	public static String[][] GrowItemName(){
		String[][] gr=new String[ItemName.length+1][6]; 
		for (int i = 0; i < ItemName.length; i++){
			for (int j = 0; j < ItemName[i].length; j++){
				gr[i][j]=ItemName[i][j];
			}	
		}
		return  gr;
	}
	
	public static void GetItemsSupplierWise(){
		
		String welcomeText = " SEARCH SUPPLIER ";
        int boxWidth = 98;
        int padding = (boxWidth - welcomeText.length() - 2) / 2; 

        System.out.println("+-----------------------------------------------------------------------------------------------+");
        System.out.printf("|%-" + padding + "s%S%-" + padding + "s|%n", "", welcomeText, "");
        System.out.println("+-----------------------------------------------------------------------------------------------+");
        boolean stopped = false;
        if (idName.length == 0){
            System.out.printf("%n %s","No suppliers are found please add suppliers. Do  you want to go stock manager(y or n)");
            String YOrN = input.next();
            if (YOrN.equals("Y")) {
                clearConsole();
                StockManage();
            }else return;
        }
        do {
            System.out.print("Enter supplier id: ");
            String id = input.next();
            String supplierName = null;

            int temp = -1;
            for (int i = 0; i < idName.length; i++) {
                if (id.equals(idName[i][0])) {
                    supplierName = idName[i][1];
                    break;
                }
            }
            if (supplierName != null) System.out.println("Supplier name: " + supplierName);
			else if (supplierName == null) {
                System.out.println("Supplier id is not found! please try again...");
                continue;
            }
            
            String column1 = "item code";
            String column2 = "description";
            String column3 = "unit price";
            String column4 = "qty on hand";
            String column5 = "category";

            int boxWidth1 = 30;
            int boxWidth2 = 28;
            int boxWidth3 = 28;
            int boxWidth4 = 28;
            int boxWidth5 = 28;

            int padding1 = (boxWidth1 - column1.length() - 2) / 2;
            int padding2 = (boxWidth2 - column2.length() - 2) / 2;
            int padding3 = (boxWidth3 - column3.length() - 2) / 2;
            int padding4 = (boxWidth4 - column4.length() - 2) / 2;
            int padding5 = (boxWidth5 - column5.length() - 2) / 2;

            System.out.println("+-----------------------------------------------------------------------------------------------------------------------------------------+");
            System.out.printf("|%-" + padding1 + "s%s%-" + padding1 + "s|", "", column1, "");
            System.out.printf("%-" + padding2 + "s%s%-" + padding2 + "s|", "", column2, "");
            System.out.printf("%-" + padding3 + "s%s%-" + padding3 + "s|", "", column3, "");
            System.out.printf("%-" + padding4 + "s%s%-" + padding4 + "s|", "", column4, "");
            System.out.printf("%-" + padding5 + "s%s%-" + padding5 + "s|%n", "", column5, "");
            System.out.println("+-----------------------------------------------------------------------------------------------------------------------------------------+");

            boolean flag = false;
            int[] itemIndices = new int[0];

            for (int i = 0, j = 0; i < ItemName.length; i++) {
                if (id.equals(ItemName[i][1])) {
                    itemIndices = growInt(itemIndices);
                    itemIndices[j] = i;
                    j++;
                }
            }

            for (int j = 0; j < itemIndices.length; j++) {
                column1 = ItemName [itemIndices[j]][0];
                column2 = ItemName [itemIndices[j]][3];
                column3 = ItemName [itemIndices[j]][5];
                column4 = ItemName [itemIndices[j]][4];
                column5 = ItemName [itemIndices[j]][2];

                boxWidth1 = 30;
                boxWidth2 = 28;
                boxWidth3 = 28;
                boxWidth4 = 28;
                boxWidth5 = 28;

                padding1 = (boxWidth1 - column1.length() - 2) / 2;
                padding2 = (boxWidth2 - column2.length() - 2) / 2;
                padding3 = (boxWidth3 - column3.length() - 2) / 2;
                padding4 = (boxWidth4 - column4.length() - 2) / 2;
                padding5 = (boxWidth5 - column5.length() - 2) / 2;

                System.out.printf("|%-" + padding1 + "s%s%-" + padding1 + "s|", "", column1, "");
                System.out.printf("%-" + padding2 + "s%s%-" + padding2 + "s|", "", column2, "");
                System.out.printf("%-" + padding3 + "s%s%-" + padding3 + "s|", "", column3, "");
                System.out.printf("%-" + padding4 + "s%s%-" + padding4 + "s|", "", column4, "");
                System.out.printf("%-" + padding5 + "s%s%-" + padding5 + "s|%n", "", column5, "");
            }

            System.out.println("+-----------------------------------------------------------------------------------------------------------------------------------------+");

            System.out.print( "Do you want to search again (Y/N)? ");
            String answer = input.next();
			if (answer.equals("Y")){
				clearConsole();
				GetItemsSupplierWise();
			}else{
                clearConsole();
                StockManage();
            }
        } while (!stopped);
    }

    public static int[] growInt(int[] ar){
        int[] yr = new int[ar.length + 1];
        for (int i = 0; i < ar.length; i++) {
            yr[i] = ar[i];
        }
        return yr;
    }
    
    public static void viewItems(){
        String welcomeText = "view items";
        int boxWidth = 98;
        int padding = (boxWidth - welcomeText.length() - 2) / 2; // Calculate the padding on both sides

        System.out.println("+-----------------------------------------------------------------------------------------------+");
        System.out.printf("|%-" + padding + "s%S%-" + padding + "s|%n", "", welcomeText, "");
        System.out.println("+-----------------------------------------------------------------------------------------------+");

        if (ItemName .length == 0) {
            System.out.println(" No items are found if you want to go stock management page (Y or N) : ");
            String YOrN = input.next();
            if (YOrN.equals("Y")){
                clearConsole();
                StockManage();
            }else return;
        }

        String[] catogery = new String[0];
        boolean isDuplicate;

        for (int i = 0; i < ItemName .length; i++) {
            String category = ItemName [i][2];
            isDuplicate = false;

            for (int j = 0; j < catogery.length; j++) {
                if (category.equals(catogery[j])) {
                    isDuplicate = true;
                    break;
                }
            }

            if (!isDuplicate) {
                String[] newAr = new String[catogery.length + 1];
                for (int k = 0; k < catogery.length; k++) {
                    newAr[k] = catogery[k];
                }
                newAr[catogery.length] = category;

                catogery = newAr;
            }
        }
        flag = false;
        int l = 0;
        L1:
        do {
            System.out.println(catogery[l]+": ");

            String column1 = "sid";
            String column2 = "code";
            String column3 = "desc";
            String column4 = "price";
            String column5 = "qty";

            int boxWidth1 = 30;
            int boxWidth2 = 28;
            int boxWidth3 = 28;
            int boxWidth4 = 28;
            int boxWidth5 = 28;

            int padding1 = (boxWidth1 - column1.length() - 2) / 2;
            int padding2 = (boxWidth2 - column2.length() - 2) / 2;
            int padding3 = (boxWidth3 - column3.length() - 2) / 2;
            int padding4 = (boxWidth4 - column4.length() - 2) / 2;
            int padding5 = (boxWidth5 - column5.length() - 2) / 2;

            System.out.println("+-----------------------------------------------------------------------------------------------------------------------------------------+");
            System.out.printf("|%-" + padding1 + "s%s%-" + padding1 + "s|", "", column1, "");
            System.out.printf("%-" + padding2 + "s%s%-" + padding2 + "s|", "", column2, "");
            System.out.printf("%-" + padding3 + "s%s%-" + padding3 + "s|", "", column3, "");
            System.out.printf("%-" + padding4 + "s%s%-" + padding4 + "s|", "", column4, "");
            System.out.printf("%-" + padding5 + "s%s%-" + padding5 + "s|%n", "", column5, "");
            System.out.println("+-----------------------------------------------------------------------------------------------------------------------------------------+");

            for (int i = 0 ; i < ItemName .length; i++) {
                if (catogery[l].equals(ItemName [i][2])) {
                    column1 = ItemName [i][1];
                    column2 = ItemName [i][0];
                    column3 = ItemName [i][3];
                    column4 = ItemName [i][4];
                    column5 = ItemName [i][5];

                    boxWidth1 = 30;
                    boxWidth2 = 28;
                    boxWidth3 = 28;
                    boxWidth4 = 28;
                    boxWidth5 = 28;

                    padding1 = (boxWidth1 - column1.length() - 2) / 2;
                    padding2 = (boxWidth2 - column2.length() - 2) / 2;
                    padding3 = (boxWidth3 - column3.length() - 2) / 2;
                    padding4 = (boxWidth4 - column4.length() - 2) / 2;
                    padding5 = (boxWidth5 - column5.length() - 2) / 2;

                    System.out.printf("|%-" + padding1 + "s%s%-" + padding1 + "s|", "", column1, "");
                    System.out.printf("%-" + padding2 + "s%s%-" + padding2 + "s|", "", column2, "");
                    System.out.printf("%-" + padding3 + "s%s%-" + padding3 + "s|", "", column3, "");
                    System.out.printf("%-" + padding4 + "s%s%-" + padding4 + "s|", "", column4, "");
                    System.out.printf("%-" + padding5 + "s%s%-" + padding5 + "s|%n", "", column5, "");
                }
            }
            System.out.println("+-----------------------------------------------------------------------------------------------------------------------------------------+");
            if (l < catogery.length -1){
                l++;
                continue L1;
            } else flag = true;
        }while (!flag);
        System.out.print("Do you want to go stock manager (Y or N): ");
        String YOrN = input.next();
        if (YOrN.equals("Y")){
            clearConsole();
            StockManage();
        }else return;
    }
    
	 public static void RankedUnitPrice(){
        String welcomeText = "ranked unit price";
        int boxWidth = 98;
        int padding = (boxWidth - welcomeText.length() - 2) / 2; 

        System.out.println("+-----------------------------------------------------------------------------------------------+");
        System.out.printf("|%-" + padding + "s%S%-" + padding + "s|%n", "", welcomeText, "");
        System.out.println("+-----------------------------------------------------------------------------------------------+");

        if (ItemName .length == 0){
            System.out.print("No items found. Do you want to go stock manager (Y or N)");
            String YOrN = input.next();
            if (YOrN.equals("Y")){
                clearConsole();
                StockManage();
            }else return;
        }
        double[] ar = new double[ItemName .length];

        double temp = Double.MIN_VALUE;
        for (int i = 0; i < ItemName .length; i++) {
            ar[i] = Double.parseDouble(String.valueOf(ItemName [i][4]));
        }
        for (int i = 0; i < ar.length - 1; i++) {
            for (int j = 0; j <ar.length -1; j++) {
                if (ar[j] > ar[j+1]) {
                    temp = ar[j];
                    ar[j] = ar[j+1];
                    ar[j+1] = temp;
                }
            }
        }
        String[][] newString = new String[ItemName .length][6];

        for (int i = 0; i < newString.length; i++) {
            newString[i][4] = Double.toString(ar[i]);
        }
        for (int i = 0; i < newString.length; i++) {
            for (int j = 0; j < newString.length; j++) {
                if (Double.parseDouble(newString[i][4]) == (Double.parseDouble(ItemName [j][4]))) {
                    newString[i][0] = ItemName [j][0];
                    newString[i][1] = ItemName [j][1];
                    newString[i][2] = ItemName [j][2];
                    newString[i][3] = ItemName [j][3];
                    newString[i][5] = ItemName [j][5];
                }
            }
        }
        String column1 = "sid";
        String column2 = "code";
        String column3 = "desc";
        String column4 = "price";
        String column5 = "qty";
        String column6 = "cat";

        int boxWidth1 = 30;
        int boxWidth2 = 28;
        int boxWidth3 = 28;
        int boxWidth4 = 28;
        int boxWidth5 = 28;
        int boxWidth6 = 28;

        int padding1 = (boxWidth1 - column1.length() - 2) / 2;
        int padding2 = (boxWidth2 - column2.length() - 2) / 2;
        int padding3 = (boxWidth3 - column3.length() - 2) / 2;
        int padding4 = (boxWidth4 - column4.length() - 2) / 2;
        int padding5 = (boxWidth5 - column5.length() - 2) / 2;
        int padding6 = (boxWidth6 - column6.length() - 2) / 2;

        System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.printf("|%-" + padding1 + "s%s%-" + padding1 + "s|", "", column1, "");
        System.out.printf("%-" + padding2 + "s%s%-" + padding2 + "s|", "", column2, "");
        System.out.printf("%-" + padding3 + "s%s%-" + padding3 + "s|", "", column3, "");
        System.out.printf("%-" + padding4 + "s%s%-" + padding4 + "s|", "", column4, "");
        System.out.printf("%-" + padding5 + "s%s%-" + padding5 + "s|", "", column5, "");
        System.out.printf("%-" + padding6 + "s%s%-" + padding6 + "s|%n", "", column6, "");
        System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------------------------+");

        for (int i = 0; i < newString.length; i++) {
            column1 = newString[i][1];
            column2 = newString[i][0];
            column3 = newString[i][3];
            column4 = newString[i][4];
            column5 = newString[i][5];
            column6 = newString[i][2];

            padding1 = (boxWidth1 - column1.length() - 2) / 2;
            padding2 = (boxWidth2 - column2.length() - 2) / 2;
            padding3 = (boxWidth3 - column3.length() - 2) / 2;
            padding4 = (boxWidth4 - column4.length() - 2) / 2;
            padding5 = (boxWidth5 - column5.length() - 2) / 2;
            padding6 = (boxWidth6 - column6.length() - 2) / 2;

            System.out.printf("|%-" + padding1 + "s%s%-" + padding1 + "s|", "", column1, "");
            System.out.printf("%-" + padding2 + "s%s%-" + padding2 + "s|", "", column2, "");
            System.out.printf("%-" + padding3 + "s%s%-" + padding3 + "s|", "", column3, "");
            System.out.printf("%-" + padding4 + "s%s%-" + padding4 + "s|", "", column4, "");
            System.out.printf("%-" + padding5 + "s%s%-" + padding5 + "s|", "", column5, "");
            System.out.printf("%-" + padding6 + "s%s%-" + padding6 + "s|%n", "", column6, "");
        }
        System.out.println("+-----------------------------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.print("Do you want to go stock management (Y or N)");
        String YOrN = input.next();
        if (YOrN.equals("Y")){
            clearConsole();
            StockManage();
        }else return;
    }
}
