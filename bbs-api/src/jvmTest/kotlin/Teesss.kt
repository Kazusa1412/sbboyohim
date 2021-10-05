import com.elouyi.sbboyohim.Bot
import com.elouyi.sbboyohim.bbsSign
import kotlinx.coroutines.runBlocking
import kotlin.test.Test

class Teesss {

    @Test
    fun test() {
        val bot = Bot(189055060, cookieString = "aliyungf_tc=48b958c2adc7801c1afd5021e2ff4d9793b68636dc279ec9300ec7a966f4c967; UM_distinctid=17aff957c323ba-087f8346c72836-5c471e3c-4e7c2-17aff957c33317; _MHYUUID=735db28c-adeb-4e3a-a20d-a611a1f5b4a2; _ga_QYFFEX7F52=GS1.1.1627883751.1.0.1627883751.0; _gid=GA1.2.667208463.1633347936; _ga=GA1.1.361808292.1627785615; _ga_9TTX3TE5YL=GS1.1.1633362684.5.0.1633362691.0; ltoken=NnXvrFZjgmNUlRj8kdjP4SsqYlONRrGxwOTsr04y; ltuid=78740011; account_id=78740011; login_ticket=hdvFsK8ZZzAdj9OS2O0vm5YF3rkwwlQtJKzZevdj; cookie_token=FfiaxrjoB2HuuL4LNYzzSbbz9zslO1g8QBHARQ6n; _ga_KJ6J9V9VZQ=GS1.1.1633399201.1.0.1633399201.0")

        runBlocking {
            val res = bot.bbsSign()
            println(res)
        }
    }
}