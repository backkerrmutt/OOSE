package LAB2;

import java.util.ArrayList;

public interface ATMAction {
    void Checkable (ArrayList<Account> account_List, int Index_Account);
    void Withdrawable(ArrayList<Account> account_List, int Index_Account);
    void Depositeable(ArrayList<Account> account_List, int Index_Account);
    void Transferable(ArrayList<Account> account_List, int Index_Account);
}
