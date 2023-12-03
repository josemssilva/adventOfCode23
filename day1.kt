enum class TextualValue(val digit: Int) {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9)
}

// Lazy approach
//fun mapTextualValuesToDigits(line: String): String {
//    var tempString = line
//
//    TextualValue.values().forEach { value ->
//         tempString = tempString.replace(value.name.lowercase(), value.digit.toString())
//    }
//
//    return tempString
//}

// OK-ish approach, but not considering eighthree 83 and sevenine 79 edge cases
//fun mapTextualValuesToDigits(line: String): String {
//    var tempLine = line
//    val textualValues = TextualValue.values().map { it.name.lowercase() }
//    val digits = TextualValue.values().map { it.digit }
//
//    var shouldRun = true
//    while (shouldRun) {
//        // check if there are any matches
//        val matches = textualValues.map {value ->
//            tempLine.indexOf(value)
//        }
//
//        if (matches.max() > -1) {
//            val min = matches.filter { it > -1 }
//                .min()
//
//            val position = matches.indexOf(min)
//            tempLine = tempLine.replace(textualValues[position], digits[position].toString())
//        }
//
//        shouldRun = matches.max() != -1
//    }
//
//    return tempLine
//}

fun mapTextualValuesToDigits(line: String): String {
    val buffer = StringBuffer(line)
    val textualValues = TextualValue.values().map { it.name.lowercase() }
    val digits = TextualValue.values().map { it.digit }

    var shouldRun = true
    while (shouldRun) {
        // check if there are any matches
        val matches = textualValues.map { value ->
            buffer.indexOf(value)
        }

        matches.forEachIndexed { index, it ->
            if (it > -1) {
                buffer.replace(it, it+1, digits[index].toString())
            }
        }

        shouldRun = matches.max() != -1
    }

    return buffer.toString()
}

mapTextualValuesToDigits("")

fun calculateCalibrationValue(lines: List<String>): Int {
    return lines.sumOf { line ->
        val digits = line
            .toCharArray()
            .filter { char -> char.isDigit() }

        "${digits.firstOrNull() ?: 0}${digits.lastOrNull() ?: 0}".toInt()
    }
}

//val testCase = "two1nine\n" +
//        "eightwothree\n" +
//        "abcone2threexyz\n" +
//        "xtwone3four\n" +
//        "4nineeightseven2\n" +
//        "zoneight234\n" +
//        "7pqrstsixteen"

fun interpretInput(file: String): List<String> = file.split("\n")

//val testCase = "two1nine\n" +
//        "eightwothree\n" +
//        "abcone2threexyz\n" +
//        "xtwone3four\n" +
//        "4nineeightseven2\n" +
//        "zoneight234\n" +
//        "7pqrstsixteen"
//
//val testCase = "eighthree\n" +
//        "sevenine"
//
//testCase.split("\n").map { mapTextualValuesToDigits(it) }

val testCase = "99lbqpxzzlbtvkmfrvrnmcxttseven\n" +
        "q7cnfslbtpkvseven\n" +
        "6threezlljtzcr1sdjkthree4cx\n" +
        "21xfxfourmzmqbqp1\n" +
        "lkdbjd5\n" +
        "8three27\n" +
        "21three\n" +
        "3lqrzdq16\n" +
        "49threenjdgrmgfnfhcgz\n" +
        "fourmsmjqfmbjvtwosevendcljsdcstl3one\n" +
        "four98\n" +
        "4sevenfddxgcvdgx\n" +
        "dffmkvmhhdbzjcgrjc5132\n" +
        "eight4one31nxlnrzvtfvrkfvgbbqmvff\n" +
        "mdmvbhqjt5rkfpcnfvzhkkfbjvh8three9\n" +
        "four32\n" +
        "seven6pljhqnineeightjjsvnqblk8eight\n" +
        "6glzfour77fiveone\n" +
        "ntvhxqzsixxcrfpgstwo915onevxz\n" +
        "81four8xkttczb2vj\n" +
        "six8flfzdzl72eightnine\n" +
        "sevensevenzsztgvh4sixbzltzl\n" +
        "2fivehgrszcrgc9\n" +
        "four53ninedrjllgffrfrtjgggvknine\n" +
        "nineonecxpzzqsptc7nv9pck\n" +
        "sixrqqfkcjrqkppvqthree1\n" +
        "1five72cxh3fivefive\n" +
        "75349sixnhxjpgtnhqlf\n" +
        "9963onefourthree6oneightq\n" +
        "51fp\n" +
        "foursix2lt7one1sevenone\n" +
        "fourddcmgbvkm8fivethreeksqghch65ztdtsdmpvk\n" +
        "35jxmgctsevennine\n" +
        "mbbkjxfthreetwoqlcrjnlvkrgnine41vkjknnmtv\n" +
        "three7sixtwohpghsdxleightthreetwo5\n" +
        "twocbtbkxhhcdrctkc14hlmdh\n" +
        "4sevensix3ninedss8\n" +
        "snqhqmffonettwofourgdkjmbjvjpgxxxpzkm8zfpfcgj\n" +
        "3xmpfmnlz9fourthree9pdnzdlcsix\n" +
        "66fourone1\n" +
        "bdkfdqvkmmstkhdsbbl5\n" +
        "48nfive\n" +
        "twothreesixthreecvsskxq3threefoureight\n" +
        "1vkseveneight\n" +
        "gskgpsix4lhrtwo88threernhqnnfqdf\n" +
        "nskfvvncxfourninehkrbxpgdsk4\n" +
        "vlm3qszxqnnzz1ptcvdxnf\n" +
        "xrppvsfourfive3sixthreebvbdkpckgheight\n" +
        "pckngkbfour3nineninepqcxvsqspbthmhzrp\n" +
        "pbtndgpfkhpflpj39zkpjcnine\n" +
        "954fourvrmftt\n" +
        "2xjrkdb8mzcfkvbdcx6\n" +
        "plt462\n" +
        "mcmzfzcdones2seven4\n" +
        "8chnpnqmbx946eightkdjvhkkbtthree\n" +
        "6zgvqslsixnine4fivethreegqqpjz\n" +
        "9twosixseven4\n" +
        "7seven75\n" +
        "four7sevenmdj8\n" +
        "6r219sevenpcvfpmfxxl\n" +
        "dvxjblhdjqttxdfourhhrgdpmvvone83\n" +
        "one3sdnfone1ddjlzhgninethreenine\n" +
        "nine3sbj5msppfonetwo\n" +
        "14tgmqlnh\n" +
        "seven5xjncjmggjppmnsx7fourdzxrsck\n" +
        "j1hphv\n" +
        "61threejjlccdzvsevenjqpbjsphdq\n" +
        "pjmsphdtwo5x6vjzmvtkfhk43hknqc\n" +
        "xfpbzdl6\n" +
        "twosix3fournlddsqmfbpslstnfiveonezfgoneighthtl\n" +
        "828fivethreetwo2\n" +
        "fmrgz5sxrrd\n" +
        "one88cjcvxddjmczjznhpnvsix\n" +
        "two9six7pkgttqdnsbgfdcdsixmskjgfvvlvqvdx\n" +
        "six7eighteightq68eight\n" +
        "seven4bsrfpxb6threesevenmgxfmfive\n" +
        "gf74fourjdflkdtrvmljskxsix5three\n" +
        "xsvrhh25\n" +
        "2sixtwofivez813four\n" +
        "kbkclv3onelmf4ntxhxbrppsixsix\n" +
        "8nine9hstninezzbflnjfxrndcpzknk\n" +
        "1hjlnsszbmtjtwo\n" +
        "2one146\n" +
        "9jdpnzgqrf\n" +
        "1qfbhl83threezxcrdfzcbbqv\n" +
        "p4lcmztns33\n" +
        "xmcsevenseven21jjfphz7sevengxlvfrrj\n" +
        "jfkmdmrfhv8\n" +
        "73spzlbvnxsqsvgpbkl\n" +
        "kkeightlrnj4three\n" +
        "4qxzfxjdmrddlhxfive173eight\n" +
        "jhmvxpbeight681gj6seven\n" +
        "mqpsxqpxj3nine9ss\n" +
        "fourdjqll2vbqbtwo\n" +
        "28fivesix6one\n" +
        "pgblvrqlnjfdtvngfbzpl5njsmvshn5tc\n" +
        "eightvvh43nine\n" +
        "dpxc5oneonebdbkheight\n" +
        "pveightwothree2kfzpkks3ljxnbp\n" +
        "vknl4xptptjjp\n" +
        "4twotfour\n" +
        "182eight\n" +
        "ninesixqkfbhgtwo3\n" +
        "twoseventwo4fivethree3one\n" +
        "sevenoneeightnine4sgkckjszmp\n" +
        "six4svkqftsrdzk\n" +
        "bhnbm96fivenineszx8sevenoneightkdk\n" +
        "rjldcxl8cxkpsdsdpgbngqeightnine9\n" +
        "5two6bdrksqgd\n" +
        "threestrhsdtmnc998xfdtfg66\n" +
        "bknkttsjf6gonesixeight\n" +
        "nine6one9jnqf1\n" +
        "qkrpkv95bd11two8\n" +
        "dksqfpmb6ttt5twothree5\n" +
        "xxhrnpjsvcq7nineonexjkcsrbxr6one\n" +
        "hsmdgfvbsk76four1sixhfn\n" +
        "ninefiveeightrflsdc4one9\n" +
        "four73915seventhfmjjqgxjzsnxvmnl\n" +
        "seven9phpseven9ftwo\n" +
        "59121fivep4\n" +
        "gg3eightgdngqf\n" +
        "4zbthb7\n" +
        "rxrhprtfb4ljdzqfmhgbzqzmrvvj1eight\n" +
        "zkvmsrvtk3two4\n" +
        "ckbk8nine\n" +
        "tbbkxr844lpkgjvmsix\n" +
        "onetwo8kbxqgvsevenmrhqndt\n" +
        "ptvgfn6rnpfkxcc52\n" +
        "three1vd\n" +
        "fivefiveeightdrljdrljxc9bjpbqseven8\n" +
        "fourx7mlksevendjtr1lb4\n" +
        "6ndfqts3two88\n" +
        "qh976eightvfch7\n" +
        "five9xdthree1seventhreeseven2\n" +
        "xvfmccmmjcjjsm5\n" +
        "ffiveeight579\n" +
        "97hcfbrhkfive39lzhgjddsx6\n" +
        "388eightkrmdktwopjdlpfmfivetwoneql\n" +
        "eightonenine4\n" +
        "bqzpzbzkbs7nprbdmbqseven8kzr1pflnine\n" +
        "9eightfourthree5four\n" +
        "cclc6\n" +
        "13one8tkfrmvcjfq4sixjlxj\n" +
        "dtrtwo9foursflc\n" +
        "3six4two3nine\n" +
        "7vkztxh6\n" +
        "xthtrhfz83six\n" +
        "twofive56\n" +
        "nineeight5\n" +
        "one5qmhmvrkktjmvhgxx\n" +
        "4four1\n" +
        "8one2dljjrvkthreehjdsbpqgtbjm\n" +
        "foursevennine51s\n" +
        "1nine8ddhdnbheightseven1\n" +
        "nine5five2375lhphjk\n" +
        "ftdrpmmzhvrxcz3vfqnhjqlqxdcrxeighteightspmj9\n" +
        "qbczvsdl449six1\n" +
        "seventwohpknrrjtvfhpxpzb3sevenn2\n" +
        "jnpxrqrtwogqsk4\n" +
        "three9fouronejjlrzqdrxkcqnd\n" +
        "ql871three1rbhtszd\n" +
        "xfbrnkzshqtwo43twohhfqdddc8j\n" +
        "ninedgj6\n" +
        "two3three6ninethreefourseven\n" +
        "4bfsl1shdzeight3\n" +
        "96mcdgv1\n" +
        "4fivefour4\n" +
        "sixfivetwo4pjbkcg\n" +
        "4onetwotrnqlgxgtxxrgxpgsevenddjfd\n" +
        "three19\n" +
        "jbnrs5bgmsixeightxzjznzkhpvsix5twoneb\n" +
        "7sixpzhsbnhrrmonetwosrjbt1jcxflk\n" +
        "74onetdh7\n" +
        "5one4cmmcmjnl9eightkvhrnkgqjstxnpt\n" +
        "seven9xttdmzsix9tbnjfgmsgfoureight\n" +
        "32five4\n" +
        "7five41lpscgz\n" +
        "48three\n" +
        "hddfhppseven2\n" +
        "5ninecbtfxkfrtccfdzplndjpseventfhqkmcm5\n" +
        "65ninesqgeightjt7\n" +
        "four3csxzztgbrninesbfzf\n" +
        "2bcnlphn\n" +
        "xsfmhnbdrj31828\n" +
        "ninezrvbf717six\n" +
        "7hlbhqxseven\n" +
        "2jrvfr5lbqzfjgpdgfourthree7srmq\n" +
        "6sixfive8nine\n" +
        "eight29one\n" +
        "onefour5ddgcrninedgdkzh1threesmcjmntnhh\n" +
        "gdg18ntxdpvvxcn7zk74\n" +
        "5onesixfnppbf2vxxbntdqvv\n" +
        "kmclhrb2five49sevennine3eight\n" +
        "6jdddgdjbgdqmkktf\n" +
        "26jhvtscmrjthreenine53mldd8\n" +
        "mkdcpnbsevencjfm21twotwo\n" +
        "3bqzmtnjhlbdszlrvpmvcgclbgfzljk74\n" +
        "8gfbmnnlltjcmjkmmvnfsgph\n" +
        "eightpcggqtqns2\n" +
        "ztzrvxglv7three5cmhnbt1five1chfk\n" +
        "9eight8cfzrsixthreevvvfour\n" +
        "3nine824ninefour\n" +
        "nmrjjp2fourd\n" +
        "twoonemgdm67\n" +
        "foursdmljtklzldsevenvbqpthree917\n" +
        "3ddzjxlsg69nine2eighttwoseven\n" +
        "6btlmdone8eight\n" +
        "7qhmpdeight\n" +
        "dxlb1\n" +
        "zp9bqm4176seven\n" +
        "5krrrsix6\n" +
        "9seven4ninexsgrqs6\n" +
        "9zzfj98fourpjzqtk9\n" +
        "svsrlmggeightpgmprpkpj486twot\n" +
        "sevenfourtwo8sevensix7\n" +
        "zqspkktb831xjlhvfourtbtvpzmlbbt\n" +
        "2gfffoursix5\n" +
        "8ccqxqm4tsdpvvxpdpcrlmktmg\n" +
        "5fivesix\n" +
        "7fourone55two7fivenine\n" +
        "9twothreethreeoneone\n" +
        "xtzc64fourzkpcqjg7twobslssjln\n" +
        "38fivetwo716\n" +
        "hkxrxtdjzdzqnrzxfzsix3three\n" +
        "onetwo8\n" +
        "ppbrqlhvqpcfx2\n" +
        "rhlbtdddqggnmfour74zcmrkdthree\n" +
        "threesix3seven1one\n" +
        "nine6six9eight\n" +
        "mzmhvmrmtvsk5\n" +
        "2qgbkrrgeightfzflbhpxctdpg39\n" +
        "61two6\n" +
        "2rzbdfmbczxcgphmonexmntkcmdxxpg6\n" +
        "b6threetwosix791\n" +
        "sevenmzlmcqxdbfmfj8ckchpkgxgmtmnzcninethree\n" +
        "jvrpkltm9n9p\n" +
        "two3bhlrgqjxbc6crzbvzmz9nqfdtztvqbhcrjptdvm\n" +
        "jdjchvpkcrfive67fivegltkrflqsbktkc\n" +
        "sevennine99jpkqljhfztbqrzm2twoctrgm\n" +
        "rcmlkj5\n" +
        "lltwo4ninestwoseven1l\n" +
        "65threerzpkhjtzxl3jx\n" +
        "ninesixninebdlfckbp2\n" +
        "fourdqqklkgcsbtwobj5\n" +
        "threesix44six2tctgp\n" +
        "9zczcltwo\n" +
        "vr6bmpl\n" +
        "7fivelpfnzgct\n" +
        "ninethreesix1twocqfpchfour9\n" +
        "1jcj81tkklgrhhjt\n" +
        "pntwonetwotnpnbmonennfblctcv91nqr\n" +
        "jnsfspcg45xkc\n" +
        "8eightqbhmrqc\n" +
        "five5threerhxffonemkbnine\n" +
        "16hqlvzjc\n" +
        "3mzjkkr\n" +
        "kcsrxhsnmqkz3two\n" +
        "9ftxzstqrdjcqddvzdxljz6sixsbxlztnqgthree\n" +
        "threeninesxt965six\n" +
        "4threenine2417qcljfive\n" +
        "4mqzxsnt3hqbhjj\n" +
        "r9ctkhvtl51\n" +
        "47kmgznjvcg5eight\n" +
        "one5rv9ztvpt1\n" +
        "2one3htxp3three\n" +
        "74six4bkqsjfgtdt\n" +
        "two2onenine9fourfdqqrmx4one\n" +
        "rvltwo9grrhsvgzr6pmnvrnlxb\n" +
        "ninefourrzgfgcfcvv8two8oneone\n" +
        "1zg5seven3\n" +
        "six91xgqcs28\n" +
        "5threemxxntrml\n" +
        "3hjltzgdgcmfmstvgfivenxfour5eight\n" +
        "five1dl8six8\n" +
        "96lkghnglthree\n" +
        "7sevenvggnkkjvzmjbbjgjhmtx53\n" +
        "9onetwo\n" +
        "6tmltdjvsevenfourfive\n" +
        "ghqkskqmbnhnone7dphgvqjzbq834\n" +
        "nllxconethree1\n" +
        "fivez5lxtfpjxpfdtwo6twosevenkhtmqbm\n" +
        "eightone4lnhlq3639np\n" +
        "8cqcjfxvclskqqnbgq8\n" +
        "qvsixgxlfsevensixhqtgmnmvk6\n" +
        "twopfccg6nine4gdhrzdqrbm\n" +
        "1hg72five\n" +
        "kqrr96jhsfxgddncone4\n" +
        "55xsfk4nqzqvthck4onerldsjx\n" +
        "ninesbcqfdlvl1sixeighthdnhsh3eighteight\n" +
        "rrspvpclvl7eightthreeqtfive\n" +
        "twobfjrmffive6three9kqmqmmps4lrjzjqt\n" +
        "fivefivejjxcmczlsdeighthdxbltgvjgthree8mp\n" +
        "one46mhghdxldbfiveckljksxm\n" +
        "c7fiveonesix\n" +
        "sixnineseven8xqb48eight\n" +
        "2mqxkvdmhgbnx\n" +
        "sixkrknqflbz6\n" +
        "6four9twogonesix\n" +
        "cbxrknrrddnfour73ninexqdhlql\n" +
        "rjtdxkjfs628eight\n" +
        "xchpj2\n" +
        "fhteightsdzsjqvhgceight43threefive\n" +
        "426jqvrxqflhch9\n" +
        "sevenmj3fiverfqzhhpvtbkrqglqzp\n" +
        "2nine8fnz3five7xjzrp\n" +
        "twofiveeightfivedcnpv74\n" +
        "7fiverkzrthree\n" +
        "gfctwonesevenhhcsvjqfourpfxjmthbcm5mttmfrb\n" +
        "fourjc9threethreetwosixpffp\n" +
        "sf9eight5fivenrlxfkjgq9\n" +
        "hd48bq\n" +
        "five21sixone\n" +
        "vgkgfvnblrdbeight245nlfnnhfx\n" +
        "3fsdrdmvrqptwothree\n" +
        "ntcx82fivesevencvdkk5\n" +
        "6gdmmvxcvp5sixthreecjtfkgnpmnthree4three\n" +
        "xpkthreethreeeightxzkdv7mgrbzxhfive\n" +
        "one98\n" +
        "5foureightmqstc\n" +
        "twothreejrhffour9twosxcj\n" +
        "twoseven5five4ptz34\n" +
        "1phdclsix\n" +
        "3chbfpvfzj51tbhpvqhninefschztfbdm\n" +
        "113tqmjkzjlgr\n" +
        "kjdrfrnzhvone6bhv8zlllc2\n" +
        "four1nine\n" +
        "3pkxz8\n" +
        "four1oneseventcspbzninenineqdg\n" +
        "one9lsmfghl6pxhbmmzxpjjthree\n" +
        "szlqptvcvskkcgxxtfrfivefive28pccjhzz\n" +
        "7sixjhhzhgh\n" +
        "onerxgnxcvprphgpzsixphrkdd97two\n" +
        "twodhqbmrz11lg\n" +
        "5ninectctwo2ninenc8\n" +
        "hntt5\n" +
        "chkjc4twokc\n" +
        "threecsix62one8tgnsqxxvpjsix\n" +
        "fhtjrljsevenfchxccpckl8\n" +
        "nine61sixrqktdm9\n" +
        "threepkzmnmnmmngxrcq7\n" +
        "4dtfivehdvcknmkj4sevend3tx\n" +
        "njcvzpmp8gmgvtoneninecnhgj3five\n" +
        "4pvqncghvr4pmlone\n" +
        "2eight4596bs6\n" +
        "twosix93fclbgfive9fourxnqdhkg\n" +
        "8onektghncz3dcklzvbdtwovsnlrcclpc\n" +
        "221threegtmppngzseven\n" +
        "jrhvplk55five7keight\n" +
        "4eightktndbfzfmskcjlm1\n" +
        "fskbxxvvsmsevenrzqrcgninemscc8vnvzseven\n" +
        "kbtsf6sixczlbqzrjfm9oneightmqg\n" +
        "vvn3threefour6sixseven2\n" +
        "6jfourzkhlllkseven\n" +
        "2twodxxhhns4gdjqmztnine\n" +
        "sevensfxztmfive7twofourqbzlzkjc\n" +
        "vqcblfvrgfourfiveseven7\n" +
        "6nineseven4\n" +
        "bnfivevbjgfzcctrhncmmnpfzmcdt4six\n" +
        "two8onesevenonecmtddxnfbjeight7\n" +
        "4sixfourdgmstmsj\n" +
        "7eight97kzxxdbdonejtsjqgjcdlssix\n" +
        "vtvdone2cjzcjltcj6six\n" +
        "ztwobmrvcbfsnine4one\n" +
        "jjblshvzsevenfoursix1ndqlgphrbbfkkcmstlsoneightfjm\n" +
        "5seventwofive\n" +
        "onebk4\n" +
        "61bgcdfjsevenhhcjjgdqhr\n" +
        "6kdvfpsevensevendg3\n" +
        "61gslvnlcjlsfgdsflqp1rnqdgktfseveneightwom\n" +
        "rvcmkdtqqglcvsxkntfour32bdptgseventhree\n" +
        "zvsbhkftlpgntvfgfxpcztm9fournmvxjnine\n" +
        "four91nptdgzk8rnmqc\n" +
        "tqmtfsixbcxspjscnine2\n" +
        "1kvmreighthnine2qxvrckqvgd5\n" +
        "dcpvrl8two1fivec698\n" +
        "xqg91snbsslnrptwoeightdzq\n" +
        "gsnvsix4vdmszmjfourfnrnine\n" +
        "9nineeightthree51gl2\n" +
        "7sixffvf9two\n" +
        "bbgqpxghsb45seven312eightworg\n" +
        "fournineeight45five4fivebrznpkz\n" +
        "dhrsrghxfivejdrqfgkdlxzb869\n" +
        "8nzxvsmrrcz1one5four\n" +
        "3mmlzvzqptttbbmtgthfive1nine\n" +
        "one9eightpzsmjvnptwonemkf\n" +
        "fivejkgrclbthree5\n" +
        "5fourtxxxvfthreelxcmghhtkqnrqzvts\n" +
        "1tlhcscbd\n" +
        "99six\n" +
        "53sixthreetwoninedjsvdfourone\n" +
        "fivefour7pbponectstmp\n" +
        "six5tnl164htsv\n" +
        "fivekbkjtjkxfszcqvppqqxdtwo29\n" +
        "42threexpdfive\n" +
        "9892\n" +
        "lvlkqlzvsix7gbxhpxrdfh2zcgccjvblhpvxqshmbbjkpgpd\n" +
        "two7sevenfourblphfkgoneone3\n" +
        "7onenine6535\n" +
        "59zv\n" +
        "347threeeight\n" +
        "8five49\n" +
        "73four\n" +
        "heightwosix99\n" +
        "1foureight\n" +
        "soneight1xzmfs8six7vpxcfq\n" +
        "nine91\n" +
        "pvxtkphg3gzgvqlfk9vhjvqmgszfivegd\n" +
        "seventwo9six2\n" +
        "2sqp\n" +
        "3twoeight3\n" +
        "8slnsxtteight429seven\n" +
        "qfjtthmthree3twothree\n" +
        "txrdqsp4oneqsprgjnnsc\n" +
        "7kqgv3five1\n" +
        "fourninegrfz2\n" +
        "seventbbfrvjqlkvm47\n" +
        "8pkqtpxfxrgpq1\n" +
        "kqvseven4n5ksixdphmjk\n" +
        "17j\n" +
        "1m3\n" +
        "ninefivefour6\n" +
        "jrdmvztnncnhnp8onefourfive88\n" +
        "kbvninetworblsd3fivesixhvhtxvgt\n" +
        "4ninesevenkpfgcddkninetnhg\n" +
        "9rdzsixsixtfbgzmhsgconethreedfxqqvv4twonem\n" +
        "kvbeightsdtqrhsscpone6\n" +
        "7fivezhxkkxlsonenine\n" +
        "sevenone7threeddmjmsjrhprn\n" +
        "eightsix5\n" +
        "4bjmfskbtc37seven3eight\n" +
        "grxbdmppllthreeeight53\n" +
        "one8jnhgjpdbseven8bc5fivenine\n" +
        "jvlmsfive43gqmpzseventhree\n" +
        "jqj9twosix\n" +
        "eightseven9\n" +
        "fourninexdzbnqsvkdvbbkb6\n" +
        "pttwone2nbone7gnpbllbhp8\n" +
        "sxpkrnshj8fivefive9kfvgjpv\n" +
        "4threepkvz2shljdn9hgrmznine\n" +
        "6seven29gnhtvshpks77fourstkdf\n" +
        "bmnfthree2threetwofive\n" +
        "51\n" +
        "jghxzhndrkfourtwo1\n" +
        "jspckbhzfcqsbone26mfhkmqztnine\n" +
        "5fgzbmgfivefive\n" +
        "six18sxvchr\n" +
        "rv7fivebdrtdl5twojt4cx\n" +
        "twofourthreetwo5onejfm6\n" +
        "threesixeight2\n" +
        "9jrmdmzvlgnine6cjlphdnine7\n" +
        "9fivembvhfrlnzbsevenngp73ninefour\n" +
        "sixxtcgjvssevenmfiveseven15l\n" +
        "threeseven6\n" +
        "cknkdqrnxrjfbn818vstmprqbts\n" +
        "4zfmxjxlkv7rdqhjfourfoureightcgvrpxfnrn\n" +
        "ghzmpsgzrkztp8s4zl\n" +
        "ninefour78rhtjfrqvh4\n" +
        "one9qzkjtsix13\n" +
        "sixfk72jjnrninertbzheight\n" +
        "rxhvxzcp366one\n" +
        "24eightthree\n" +
        "teightwofprzdscnts4nv88\n" +
        "eighteightshqcbqzxmbktwo54fourpdkf\n" +
        "sixfhvgkfourfoursjxnstgqnjh2\n" +
        "6two1vtnqbrhqjbnkm7six9six\n" +
        "66threeeight\n" +
        "lbdkggsncthree315\n" +
        "8gqsrmseven3gvvxq99\n" +
        "sltgzbgbmg1\n" +
        "9twov6\n" +
        "shhbqkcc71threecmkl\n" +
        "cgqtpsjkglzszffcnineninesgvj1\n" +
        "fourhqnlhrrsbrsevenkrgffivefour6eight4\n" +
        "twojdccnhk6fivelddgrppkldtdlt\n" +
        "4dlkn5x\n" +
        "12sfdtvcqztxmtvvkds\n" +
        "44one6jxjdbsjxpg\n" +
        "7sixfmbbfxnjjhj5qkqfvfntonegdktrfl\n" +
        "eightfourzkdxgqn8\n" +
        "1fourthreetbvtpphj4rmrhlcbxbrqfdxszfour\n" +
        "eight42onehpvrlbkglq\n" +
        "9five2five5\n" +
        "bnzbccq26mblqtjxlsbtdvm\n" +
        "nineninelnknxhbfk4xssrlsdmsixoneltjseightwofzf\n" +
        "8mleight7zhfsmsmpdthree\n" +
        "mjcsr5tsktfpzc2nine7\n" +
        "tmlxbkh79four7\n" +
        "fiverzrfvlcdnmkn46onennxbbvn\n" +
        "threefournine9\n" +
        "snz6bcgqlhx\n" +
        "4ninevqjlbfklgz\n" +
        "8fsvsfiveone9fvdfiveg5\n" +
        "eight5dhcgxjts\n" +
        "ljldjmfmgtzclfhthkdtdthree4\n" +
        "qrlmdjmkvvtwopdphfpmdd6fourxkblfqcx5\n" +
        "62glckjgdvnpfourzlkphvrjffive\n" +
        "nltxkzk2zhmqhfqq\n" +
        "95six8xflfzhf3\n" +
        "zsfvrpjx67\n" +
        "two4vfivehglclslddsix\n" +
        "gssccpnhjx5128foursxpgrgztdfour\n" +
        "87fourpqdrxmvqdmxfrtzthree\n" +
        "one85fmkj\n" +
        "5rtjzsevenfive1thpzqxxm5\n" +
        "bone78\n" +
        "4three83947\n" +
        "sixffkfmhzfkksevennllffhjvkxqhpjjtfl1\n" +
        "foursixxvfst6twosbvjfvcb2t\n" +
        "fgzthreekkpffive5four\n" +
        "685jfttdmjq\n" +
        "t4\n" +
        "xqeightwojhbrrrqgdtbcqlhthreesixsreight7rxxgqntqdqlbnm\n" +
        "stbmgqjdvqfour4\n" +
        "dfour11gfcvx4nine5\n" +
        "eight4fourseven5five\n" +
        "six3seveneight\n" +
        "four2sevenltvckjxjhjfslsvgpzxffivefive\n" +
        "27one5vdtkjt4\n" +
        "fourzpr1gxgone\n" +
        "gtfive5hbqktbfour5g2tk\n" +
        "nine2pqhqgprxrg9hgjj4\n" +
        "twovcjkcsqznsix557psh2\n" +
        "1fkpjccjffr7nine3gxzk\n" +
        "5threezzbbvtcbvj4\n" +
        "8nkbdhct\n" +
        "8eight2\n" +
        "six17ninetworpc4\n" +
        "qljgkvq23eightfourfour\n" +
        "onebblhxbnlhztgrkchlbtwo5\n" +
        "sixthreevmngjjgpfourrrblxqvcl22\n" +
        "mcnksthree81xrzrrrvnvdvbzfzlrgseven\n" +
        "chjxhjjxthree3\n" +
        "mrmxzpbxnh4sixrxskzvnjtlkjddnrpkbjhslbxjbkq8fsix\n" +
        "2kgfmzeight\n" +
        "plvslqzpbk7\n" +
        "xsfq49ljfts\n" +
        "seven2x9hpzbhqzpffoursix8\n" +
        "5999one1mbnxmrqcxv9\n" +
        "eight52prffgvvgznineseven\n" +
        "l8onehqzcf\n" +
        "sixkzxvqdgnbbmdtrvhzfouronekmklkjp34v\n" +
        "98144threethreebvcjpllggz\n" +
        "nine7twofive9sevenszvdrq\n" +
        "jnvcprvbgtfourthreed9pm3\n" +
        "tszbl9one5dfmsmkmlvfrlf\n" +
        "537tmcrdxp\n" +
        "sfcqfrrcqj26\n" +
        "8fourfoursevensixmlmqzggmrfive\n" +
        "kbmbxz1onelqtdxxk3\n" +
        "45mxksixfour\n" +
        "7zncmh2\n" +
        "hzoneightsixfourzzlkmrnzptllthree2tpdjtsszxnjdhkgv\n" +
        "ztpqbd68814five\n" +
        "92gnzsvldmvhhzb8\n" +
        "ninefour2sixseven1seven4vcnkgklh\n" +
        "sevenfsjrdhclm7six8nlrhdpplbjg\n" +
        "sevenlgd86\n" +
        "pg75sixtwozk\n" +
        "734eightone5gssxhffscq\n" +
        "5sevendrxvkmfsjkgg5twocqpqlhksrp\n" +
        "seven1cktfl\n" +
        "mrs7\n" +
        "2foursevenninelpzxthreetwojmbvfzs\n" +
        "2rdsjl1three1\n" +
        "xrkztslbkgdzgjjtst5six5fourthree\n" +
        "twosixfhlldtwo2sevenfourknbfgnnjs\n" +
        "nine699two9pp1\n" +
        "9kdlfour8kzfm57two\n" +
        "hlmscnhk1cqqzqbsxqglf9jgpjnfrjczeightspkkzrdqjd\n" +
        "72six7mjsxfxtz5\n" +
        "3sixonebkfgp\n" +
        "fivefourvslvn2six\n" +
        "19pshkt\n" +
        "739bzfpltmtsevenfour27\n" +
        "fvps6pprtjlq5foureightworm\n" +
        "qds3zdsgzxvthreethreeeightdqjbtrfjbbj\n" +
        "nine3148oneeight\n" +
        "nineggvmffthree1fivefbkmmfvjkpcgsxrfzg\n" +
        "7vlff9msmx3njb76\n" +
        "hsthree4jfpvhxnceightkfseventhree\n" +
        "hx3seventwonineklbq7six\n" +
        "38zeightjlxj\n" +
        "jdbqgmsix8\n" +
        "seven8njthzbdrtninexkplhnrfourone\n" +
        "tnhhzhjccjdtpleight3onegsevenxkqbmqzx\n" +
        "4679scb2\n" +
        "twos334fourfivefourfour\n" +
        "sixseventwo356\n" +
        "xnmsevennlr78jlfrbgb\n" +
        "four7krmgzcclgf6dteighteight\n" +
        "94mzfhdk\n" +
        "7two43threecthree\n" +
        "lztbgnscq7ggeightsevengtjpseven\n" +
        "nbcrvpljfive1threefive5seven\n" +
        "fc895\n" +
        "eightlqzzlgrxv9gdfcrpkxkhzgbjtpcgncppm\n" +
        "8cfjbngnd6371threedczkfqmptxtrqt\n" +
        "6jblvpxskcnine\n" +
        "onexvkxthreebcvnnrctsix1oneightsrd\n" +
        "two66fourfourdnccpl\n" +
        "3fourbqznm\n" +
        "eight9lbz3eightfourmonethree\n" +
        "2qpvlbbb\n" +
        "threeoneone1mjhqfive\n" +
        "2threenine\n" +
        "two6qvxnnqj91eightfourkqxvhq\n" +
        "rtsftmvb14\n" +
        "kvzptdxdfsrm5four5three\n" +
        "sixkfjjbccbeight3eight\n" +
        "kjskjrnbfs29seven6\n" +
        "68qxpjrz\n" +
        "eight4cnmx9four9eightvbsvvsix\n" +
        "6xvsptbqcsxlcdzcnzrninehhrjqjsixkk\n" +
        "seven7vknjphhfbs\n" +
        "rjmhjgmpzk22fjmtmtc7spgkfkqgcn\n" +
        "three8ftxlktggjn2rfljxmlg9\n" +
        "9threehlvtmftzfiveqghnvmtbseventwo21\n" +
        "pceightwopbpbj3two2eightfive7\n" +
        "lsdbf6five3nddpcnnine5xvqx\n" +
        "2sevenseven86lldmhf\n" +
        "8rqhnhsrcjnfzgpcclrmnlvbphrtgchpls9\n" +
        "kxeightwoxsrvcbzhhbpdlrt22fhqfivefptwo\n" +
        "bdseven2hnqccjqgxjvjk86xvbhddlbx6\n" +
        "zszz4kqtsqjfpqmcxbndmbdseventhreeeight\n" +
        "fourfiveoneseven83twotzblfpldfq4\n" +
        "tgbxlthreezdfspjsnhrmrqxqj6cplcczt2pgsbfczn\n" +
        "jzdkc6xfmhpqstvzzmvxk431\n" +
        "7eightqbxcnsgxm\n" +
        "5sixeight\n" +
        "6sixvjstz\n" +
        "4trxhdlkzqvjpzgpvfp1\n" +
        "sixqhghvddcdn7blhptxp5htcf3\n" +
        "nineksjvmvc2\n" +
        "41krm9\n" +
        "nine42sevenfive2\n" +
        "zfivepkfqrgpkmxbmjbq6tgktpvnjvdjzsd\n" +
        "gssrnnqmm7sixfivelklmggxgkdtlmlzqp\n" +
        "64qsevenftmjzgs\n" +
        "6nctkfbskghpqr7\n" +
        "8nine3\n" +
        "hkjoneight6seventhree9\n" +
        "11nineeight9nine\n" +
        "845fouronetwothree\n" +
        "pfhb14v\n" +
        "three21kdgcplbzzbeighteight\n" +
        "4cszltd7ninerrmhjqmtrprtccpjnjgdbdtwo4\n" +
        "five96\n" +
        "2lkfbsnq64three\n" +
        "srltvpbgnxvlksmfzpj2\n" +
        "four9tpjvhhpsctclzpnsr1fourcttqvng\n" +
        "gpjxncqsbp46vb9tqgnninetwo\n" +
        "four1four\n" +
        "6dtklvddhlprphffpnkrksfseventwonek\n" +
        "eight4seveneight2onezfbnvjplvl97\n" +
        "7ndvfp8qstcjdgzcfcninebj\n" +
        "9beightbsbphgrnq1ninesixsvthrx\n" +
        "bpxthreezkhjleightsbxmsdeightseven4\n" +
        "fivemlfsninesix1nine6six\n" +
        "4fivethree3qtqsbscnc\n" +
        "four7dsix3kfhrrgbbnlzdfbgxsix\n" +
        "hqckztqxgxeightkfmvvjg6tp4nine8\n" +
        "tmgfmcl2twonedg\n" +
        "fmvvcsix8nineninepqdrcmhdzsixtwohcnrss\n" +
        "nine258foursevensix8eight\n" +
        "8q\n" +
        "pqjqrxnine2one\n" +
        "9sixpbxr43sflnine3\n" +
        "4onethreeonefoursixonefour\n" +
        "1vnscdrnnfpkrj8mndxbqdrckzgdpnfdone\n" +
        "threeseven7six8three3six2\n" +
        "jvt24pjtnxdcpsthree\n" +
        "7nxfpnfzrssvqqcnrjnine47\n" +
        "cflhgfournine368\n" +
        "62srjsxgr\n" +
        "mnsix6fivefourjdnqfgjvp99two\n" +
        "8five6fdvgctwoeightcsmspmxmbgjqzjhlhb\n" +
        "seventgcdvchsfivefour9nine4seven\n" +
        "bbzvxfvmxhqv26rp5\n" +
        "2psmsflpgqmb\n" +
        "eightnine4threekgfjmhbkhtxgr4threekxnmspvbfs\n" +
        "seven9two84phzrrvftgpt\n" +
        "xgpfkphfchzptzvconetxcp3qdmdn\n" +
        "five2fddc8hdzrzgcgdtonesix\n" +
        "one24sixtwo\n" +
        "mxfltrcltqjmmtj4psbf\n" +
        "jbrskjdtthvksk9mhfxjgdjt\n" +
        "four96njn\n" +
        "five8tqltpdxrklninednqkmgstlptpjhqvklnjhrvpzvpfr3\n" +
        "onecsktmkt9\n" +
        "seveneight1\n" +
        "nineeighttwo1txhjjkqzqtnine\n" +
        "37onegfcf253\n" +
        "4ninethreepndgnfqpvqzxbxkpgp4eightwozg\n" +
        "tfxnx999864three\n" +
        "sixthree19\n" +
        "3nineonefive\n" +
        "rpht1onetztgngmeight\n" +
        "9928two4six5sp\n" +
        "gmhtwooneclqfdqvfivefour5\n" +
        "two3dkkfive\n" +
        "7four6pklfxjqhgbvnpxmndsixthreetwoeight\n" +
        "5eightthreeseven9\n" +
        "9fourseven5pmtcdpfvhjj\n" +
        "24fhbms2sixtrjtm\n" +
        "seventwob99\n" +
        "3mffcdvdqsixgxtbrxqddkrzclz92\n" +
        "5fivenkmtgbsnsixeight\n" +
        "3seven9hcbmcnjvqfour7\n" +
        "bvspr4jhjlnddp3eighttwosixfour\n" +
        "kdvh5\n" +
        "seven7hvcmdfkfour5nine\n" +
        "1ksqzfnmhfqjjlklptmmpvxnine6\n" +
        "fxp7hljzvndnd2mpqm8\n" +
        "86qxntjqmljdqpdbftqfrfiveninefcxzdqctbjppc\n" +
        "one62\n" +
        "two23fivesgtsqpjrkvlbrfknjgcjbt\n" +
        "29gkcpcfdlm3\n" +
        "ninehzvhg2one\n" +
        "ljv73tpfjvbhlxnpxqxhfivefivezxtzhlfsc\n" +
        "three7637\n" +
        "rnmkzqgtjpfbn3nine8nine9ttcsdbr\n" +
        "jqtwo7fourone7dclxtnlnthree1\n" +
        "872fivemjghskxcxmninexljstpvb\n" +
        "9hdjtfkqsb8skkvpfpgqlctvlz\n" +
        "nqnltrnsevenfbsixmnxrv87ffsjn5\n" +
        "fkxzbxsbbfour17fivenine424\n" +
        "ccbrxlskjzmrclgchlxlcpkck2\n" +
        "one9sevenjgxrk33twonepjs\n" +
        "5eightthreefivethreetwor\n" +
        "zxqdnhnk51\n" +
        "two39xctxpvsmfivenbtsmpcg3eight\n" +
        "three52threevgj8\n" +
        "1twom52\n" +
        "3pthscht\n" +
        "8ninegx3f8\n" +
        "lzjvthree96jgfhfvsbv7qfour9\n" +
        "threenineeight722ltvvxhdczjfivedcxbst\n" +
        "fourgvlbxrone8btblnlbkmx51\n" +
        "one5nine93fzxthreebzchcqjbrxxct\n" +
        "3sjbbtbpkr1onectngpqpdfp\n" +
        "5xdgpgpm\n" +
        "nine9onev952\n" +
        "fxc9seven\n" +
        "fiveggdqqlspfoursevenfour5three\n" +
        "7ninekhxpdgfive\n" +
        "3fmkhhbztk\n" +
        "737\n" +
        "3kx2sixgrgslpfvvlfourfive7gbk\n" +
        "1rqjxnfmzkvxxsixt\n" +
        "fiveszkkmrtrctjgqvcfbg5r5\n" +
        "6onefoursixntbbrjxfrfournpjbgcx\n" +
        "sixgpbbbkhxdj4skfrvnnlmmhxcpfnxfive\n" +
        "two37hjdklhtvtwonzhcqrbfv\n" +
        "eightsix7\n" +
        "four9253njcqvvhtgs\n" +
        "fourfive3bxnvck\n" +
        "ninelsrbgctxvn59six\n" +
        "3jzqb7six69eightonenine\n" +
        "73nine6tkrqsc3kthjdmdtmsixspvvr\n" +
        "8691twothreeeighteight\n" +
        "8ninetwo7nine21qpkbml\n" +
        "3lttttwonemh\n" +
        "8eight9onefpscrm5\n" +
        "qgl38onevqjbfldcg\n" +
        "dbcxgcfsf23jbb6eight671\n" +
        "18pzgfqjsfourthree4bvqtxsh\n" +
        "fiveseven7mdgmsbdphthreefivedpzjbjc\n" +
        "7onemmspfpbfbftcpgvxhmh944cvdvlp\n" +
        "96hpgcqlp8six\n" +
        "two5jrrsix4dktmzkqgvb\n" +
        "two93fourninekfkkgdxbvk\n" +
        "93onesdnxqtwo\n" +
        "jxmfmmvlxzseventhree5sfconeeightkrzdcvnhpvmfnz\n" +
        "86gkxpqspnxs\n" +
        "seven9pblxnnkkjffournjlkgqmonedxqseven6\n" +
        "jtddqv7nzpsixseven\n" +
        "vgjkbfnc29gskmmjmgsrbvghgrbtsbrdglszsix6gm\n" +
        "gjglfour8three7five\n" +
        "seven8ninetc4foursevenxfxlvmt\n" +
        "sevenone21nine\n" +
        "9onefouronevqrsthmlone\n" +
        "8threemsrbrchmk22fivepjdxprpvplt\n" +
        "rsqkrlnfpsixfive3three77\n" +
        "twoeightseven2threejzgzmzzgqdrcmf\n" +
        "three8lsctcbnhgkpr3\n" +
        "4ktrtzn\n" +
        "vqhvfxrxhpdgqhcrrczjlmhdnlzseventvtrrktd9twonenqn\n" +
        "twonineeight7\n" +
        "67sixeighthvfkjhtj5\n" +
        "644\n" +
        "onezdfz6\n" +
        "6qmcd9ninenineninetwo8\n" +
        "four7nine7\n" +
        "4hjnndn\n" +
        "1fqfqdqqxdnvhmqcp8\n" +
        "rrhndnbpjjzhclhv9ppvlbtxklzfivejhxzcbpmd\n" +
        "six7526\n" +
        "8ninefkhszlp2\n" +
        "fivesix34twocg14\n" +
        "3sixfive\n" +
        "2nine3\n" +
        "2hv4rrfh3two8lr\n" +
        "sevenrqbzmkmcn22\n" +
        "56vrglvbcdtxxrnjrlhpffr\n" +
        "mfddxflkqd4six\n" +
        "bfsfnkqxc76rtpgss3pkqkksrcxnine\n" +
        "83fivemnjdfnk85zqmssgfffourvgqjbn\n" +
        "822\n" +
        "dvxgqrbjpnqvpsfthkz6\n" +
        "4fdlzcxeight8crmrztfdmthree7eightfive\n" +
        "two9threefourtwo8vj2\n" +
        "nine1jxpclfhj\n" +
        "jrgfxlgblzqnr9mnfrcsixone\n" +
        "5t3nine5\n" +
        "twogxssevenoneseventdc3\n" +
        "rvzcbtwofour4sixgfzk\n" +
        "six22eight81ninepnscnlv\n" +
        "eightfiveeightsevendxx1gh\n" +
        "7nzlpbx864g5\n" +
        "hxgdrrnnsix1sevennvmsvdvccpmfive\n" +
        "1threevz9\n" +
        "36eight4xvnrghgjf996\n" +
        "nine8mmtqkffkthree8xpmsbksix\n" +
        "1fivejrgqrjjnql2dvmcqdbjbsix\n" +
        "15fiveseven1td3\n" +
        "kmfmbhcmf62five\n" +
        "36dxfoneninefivehrr6\n" +
        "four54sixfzhq26\n" +
        "1427qjseventhreefiveqhv\n" +
        "eightghnnlddqdpm1\n" +
        "9jbcfdjzjxreightlcpmdddts\n" +
        "6ninesrdgkrfivefoursckkrfrpqqhgzeightwoj\n" +
        "xmqsnjgskfour8eight\n" +
        "9l8one\n" +
        "four9jghzbrsix7seveneight4\n" +
        "9tgsvk\n" +
        "sxgkkbnlsbnbbc2ckqhzgdlsbhp\n" +
        "6ktwohsvbeighttwo\n" +
        "xgfrrnrlkgdqfxdtwo9fvthree\n" +
        "5hqdvsdnrvr81sixsqjmbdls\n" +
        "kkghseightsevenmtbtvplcjnqtscx6\n" +
        "rveightwobhqtmjhsrptpzkbv3ninem\n" +
        "3qpgbd2fourqdsnnbgmnsqgdb4\n" +
        "mfive12\n" +
        "52xqhpfdjgmeight13tcn3four\n" +
        "6lkgjdj\n" +
        "rvsvpt144lrtvrtpvd\n" +
        "8fourfive8\n" +
        "28dhzrtfcjlgchxbthree\n" +
        "vvsixtwodxfz5six\n" +
        "seven7rcp7\n" +
        "threethree136gts9threenine\n" +
        "9477\n" +
        "seveneight8gmhthree8\n" +
        "nn633sixzxcxthree\n" +
        "two95rfcffourtwo3\n" +
        "76nine\n" +
        "cvhlpzsbmknkqpgsevenlkzvm7hnznjsbszgvxrmdnn4\n" +
        "pnlqmxlmvkkpdgktwo1four41one\n" +
        "4hgnhzkbmlvkqpqqptd93two\n" +
        "lfsnfs7eightvdnghthree\n" +
        "shpndlkr7five1three6\n" +
        "sevenfourfivesckjjlzgv27four\n" +
        "xhtpxlqssd3eight6two6\n" +
        "48ckzhkk84seven1ggsffz\n" +
        "33rqthree6jvqlbzllz\n" +
        "4jfourthree6\n" +
        "jkhflbhqhtmpmhmonebfbmcmczbspj9sttmnvnvgfivekz\n" +
        "eighttwodk25sevenninenine2\n" +
        "oneqqxfkffivesevenzqhvjtgjlrninenine1\n" +
        "2nineseven82fivethreezzqfjm\n" +
        "mh4\n" +
        "3tjfmrtnff498\n" +
        "five7three7three52eight\n" +
        "jgrndnjckvc1\n" +
        "9sixgvv\n" +
        "six3rfpxrl9three1chczskrxthree\n" +
        "6bjqqzfqcxvnxbkpq\n" +
        "922\n" +
        "loneightnznrcpd6cpfsmclp\n" +
        "7five7qncxmfhleight\n" +
        "bhsgbsdnsixnine4msnfmonerjbpvkqf6five\n" +
        "4xrcrrllzh9two6zgcftpfqj47\n" +
        "six31two5fourthreeeight\n" +
        "gqhckrzrpltwo72znb4oneeight\n" +
        "trsxcpls3pmqqrskpmfivehdqrptvdtq\n" +
        "six3four87one\n" +
        "46two3\n" +
        "9fiveseven57vhmq\n" +
        "jkrbkfsevencnvzp89vhmsdcfcthreetwonedrl\n" +
        "9cvzvqfboneffive6jmnpjkvrjz\n" +
        "82xrqjdqchdbvhxpninefourdhb\n" +
        "3bqsrf\n" +
        "fourtwosixsevensix9threesixthree\n" +
        "3fourkgjbxbpsrtgsmgrjthree\n" +
        "ndeightsevenfourtwo943\n" +
        "471pn6\n" +
        "bpstsix84four32\n" +
        "gjkcq89ninegkckjpkz\n" +
        "eightkgvmxlzlhrnrdpttdqbthree117\n" +
        "vtdnlkqcg65\n" +
        "btwone727onesevensixkhbnkvtlthfjfive\n" +
        "twozspnzkssqseven413\n" +
        "7nttlqthreenspcdrhdpn563\n" +
        "six3nine\n" +
        "4twodkrlmssknsgfourkcfrxskpntnine\n" +
        "qgtgfxhfjj3pslzsttxpfive\n" +
        "fivethree9ct55sevensix\n" +
        "8twooneonesixjlszd1hlhbcgjf\n" +
        "fivetwosixsevenmrzjqjtfourmrk7two\n" +
        "pfnine6sevenone\n" +
        "3threex94znone96\n" +
        "79two2sixeightqmnbxcxf8\n" +
        "oneeight5\n" +
        "763lsdvlz24threed\n" +
        "four9oneeighthdcrzqlnvxj6ninex\n" +
        "7552twojhv4\n" +
        "3rzxhddcfxone553one9\n" +
        "sixsix8\n" +
        "7seven26k\n" +
        "86onethreenine1vlnmvghn\n" +
        "sevenglrmsnngpf3mfblll3seven\n" +
        "npdrbsxxpcpc3jzlpljsnlsrvdmvtr6one\n" +
        "6894one\n" +
        "rjzxs7\n" +
        "7mllptmtwoqxrpgprvqrstmvvvvm\n" +
        "sixone12\n" +
        "225\n" +
        "dcjzmcnbpptwothreedzqctmhm4seven3qhnbn\n" +
        "oneone2six56jsmdjqcznjtwolcjvmpkxlj\n" +
        "2sevenseven\n" +
        "7cpnpkcqsstfourjthreenbzvrdgeightsevenhfnztth\n" +
        "4phcrvcgseven4njn4\n" +
        "three9fiveninefdv\n" +
        "63ll\n" +
        "9sevenx7\n" +
        "9fivehvtfdckjnpvk\n" +
        "gpkhmlrxs5two39\n" +
        "kfvqv5oneonefiveonethree5five\n" +
        "2mrjctkmlks4z\n" +
        "8eightkrzkdxvrrjvtwo2\n" +
        "fiveninesix9\n" +
        "rhtnxkvthkpbqn4mtgtdnmmxmvmmzmcbt1\n" +
        "mtwonexdljqqgbbnineqrgbqnqx7eight\n" +
        "fiveeight8sfvzbpkeights4\n" +
        "8threesix8two8hszvhcbonefour\n" +
        "tpjtvpjgtnine2rbbfd\n" +
        "zrxjftfg4b6three37four\n" +
        "th5kktbzgmvkxhhcsqcrvtldnldml7seven\n" +
        "4txnqnplsixzptgszd\n" +
        "gzt5threefiveninetwoeightsevennine\n" +
        "jtfrlffv17268\n" +
        "qfour9six\n" +
        "49vrbpqkkzct6\n" +
        "14two\n" +
        "nine2drdcd7sixpfvsblcxqsjshhg\n" +
        "5onehfivefour8mnine\n" +
        "5qlthree6hbkktrpbmgninepqtxq\n" +
        "three8four\n" +
        "ftm67qrmsix\n" +
        "seightwoplhzgbvb7275\n" +
        "qnqtbdmqd4\n" +
        "onefive2lcrdjrzbheightthreegvc4three\n" +
        "87eight4fiveninefiveeight\n" +
        "1seven7eightfivezqcndfj5cmblgczd\n" +
        "seven6rkxsvbs529fbgbtclkjhcljpkjbgmvz\n" +
        "1twojxpxrgvvzq14ldngl9eight\n" +
        "qkg2fivemrlzlhxxzcmfive\n" +
        "one85four9six8eight\n" +
        "7sixbgvdf4841\n" +
        "hktntngtlfflzrdpfourninevlzpdrngvchg2\n" +
        "6two115\n" +
        "fiveninesevenqxgjrnk3two\n" +
        "eightthree988nrclmr\n" +
        "2one6\n" +
        "6737jfive\n" +
        "8four3\n" +
        "4fivesvntkxfpnqhone94three\n" +
        "7six1twothsd86\n" +
        "98pczqhlqbzjlvfnine68\n" +
        "xtqtwoneeightlvcjqfourckfour2nine\n" +
        "9sixllhhqhfivemmoneeight9\n" +
        "4czj3\n" +
        "ggdlxrrxjl1jnndbgbdninesbcfhd2five3\n" +
        "kszvbdfninethree5onevflrqffxmdonefour2\n" +
        "1nkpmvbf75\n" +
        "lnbgnkkfhseven5zfive2qcr\n" +
        "seven75xcx\n" +
        "2eightbzsp2pfg7eightv7\n" +
        "fourone29\n" +
        "4two5two9xcpkkjqxcfivessqqvhbbt\n" +
        "ncnqg1sixt9ninedlfgsqhnxx6\n" +
        "xrlsktwodnbcbonefvxxqgbrsdthree3seven\n" +
        "klvsv73\n" +
        "onezvbhrblrkzcrsevensix96jnpxjone\n" +
        "nine6chd4\n" +
        "bdvkqlrh9eight6eightninehq7\n" +
        "fivexpx1vsrreightkp7dph\n" +
        "3eightlrrlgck967\n" +
        "xcntwone4633sixmkm1nine"

calculateCalibrationValue(interpretInput(testCase).map { mapTextualValuesToDigits(it) })