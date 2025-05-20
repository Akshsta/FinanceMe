@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    // 1. Create Account (POST)
    @PostMapping("/create")
    public Account createAccount(@RequestBody Account account) {
        return accountRepository.save(account);
    }

    // 2. Update Account (PUT)
    @PutMapping("/update/{accountNumber}")
    public Account updateAccount(@PathVariable String accountNumber, @RequestBody Account account) {
        account.setAccountNumber(accountNumber);
        return accountRepository.save(account);
    }

    // 3. View Account (GET)
    @GetMapping("/view/{accountNumber}")
    public Account viewAccount(@PathVariable String accountNumber) {
        return accountRepository.findById(accountNumber).orElse(null);
    }

    // 4. Delete Account (DELETE)
    @DeleteMapping("/delete/{accountNumber}")
    public void deleteAccount(@PathVariable String accountNumber) {
        accountRepository.deleteById(accountNumber);
    }
}
