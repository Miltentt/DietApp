package com.example.myapplication.Model


import com.google.gson.annotations.SerializedName

data class Edamam_Response(
    @SerializedName("count")
    val count: Int,
    @SerializedName("from")
    val from: Int,
    @SerializedName("hits")
    val hits: List<com.example.myapplication.Model.Edamam_Response.Hit>,
    @SerializedName("more")
    val more: Boolean,
    @SerializedName("q")
    val q: String,
    @SerializedName("to")
    val to: Int
) {
    data class Hit(
        @SerializedName("bookmarked")
        val bookmarked: Boolean,
        @SerializedName("bought")
        val bought: Boolean,
        @SerializedName("recipe")
        val recipe: com.example.myapplication.Model.Edamam_Response.Hit.Recipe
    ) {
        data class Recipe(
            @SerializedName("calories")
            val calories: Double,
            @SerializedName("cautions")
            val cautions: List<String>,
            @SerializedName("dietLabels")
            val dietLabels: List<String>,
            @SerializedName("digest")
            val digest: List<com.example.myapplication.Model.Edamam_Response.Hit.Recipe.Digest>,
            @SerializedName("healthLabels")
            val healthLabels: List<String>,
            @SerializedName("image")
            val image: String,
            @SerializedName("ingredientLines")
            val ingredientLines: List<String>,
            @SerializedName("ingredients")
            val ingredients: List<com.example.myapplication.Model.Edamam_Response.Hit.Recipe.Ingredient>,
            @SerializedName("label")
            val label: String,
            @SerializedName("shareAs")
            val shareAs: String,
            @SerializedName("source")
            val source: String,
            @SerializedName("totalDaily")
            val totalDaily: com.example.myapplication.Model.Edamam_Response.Hit.Recipe.TotalDaily,
            @SerializedName("totalNutrients")
            val totalNutrients: com.example.myapplication.Model.Edamam_Response.Hit.Recipe.TotalNutrients,
            @SerializedName("totalTime")
            val totalTime: Double,
            @SerializedName("totalWeight")
            val totalWeight: Double,
            @SerializedName("uri")
            val uri: String,
            @SerializedName("url")
            val url: String,
            @SerializedName("yield")
            val yield: Double
        ) {
            data class Digest(
                @SerializedName("daily")
                val daily: Double,
                @SerializedName("hasRDI")
                val hasRDI: Boolean,
                @SerializedName("label")
                val label: String,
                @SerializedName("schemaOrgTag")
                val schemaOrgTag: String,
                @SerializedName("sub")
                val sub: List<com.example.myapplication.Model.Edamam_Response.Hit.Recipe.Digest.Sub>,
                @SerializedName("tag")
                val tag: String,
                @SerializedName("total")
                val total: Double,
                @SerializedName("unit")
                val unit: String
            ) {
                data class Sub(
                    @SerializedName("daily")
                    val daily: Double,
                    @SerializedName("hasRDI")
                    val hasRDI: Boolean,
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("schemaOrgTag")
                    val schemaOrgTag: String,
                    @SerializedName("tag")
                    val tag: String,
                    @SerializedName("total")
                    val total: Double,
                    @SerializedName("unit")
                    val unit: String
                )
            }

            data class Ingredient(
                @SerializedName("image")
                val image: String,
                @SerializedName("text")
                val text: String,
                @SerializedName("weight")
                val weight: Double
            )

            data class TotalDaily(
                @SerializedName("CA")
                val cA: com.example.myapplication.Model.Edamam_Response.Hit.Recipe.TotalDaily.CA,
                @SerializedName("CHOCDF")
                val cHOCDF: com.example.myapplication.Model.Edamam_Response.Hit.Recipe.TotalDaily.CHOCDF,
                @SerializedName("CHOLE")
                val cHOLE: com.example.myapplication.Model.Edamam_Response.Hit.Recipe.TotalDaily.CHOLE,
                @SerializedName("ENERC_KCAL")
                val eNERCKCAL: com.example.myapplication.Model.Edamam_Response.Hit.Recipe.TotalDaily.ENERCKCAL,
                @SerializedName("FASAT")
                val fASAT: com.example.myapplication.Model.Edamam_Response.Hit.Recipe.TotalDaily.FASAT,
                @SerializedName("FAT")
                val fAT: com.example.myapplication.Model.Edamam_Response.Hit.Recipe.TotalDaily.FAT,
                @SerializedName("FE")
                val fE: com.example.myapplication.Model.Edamam_Response.Hit.Recipe.TotalDaily.FE,
                @SerializedName("FIBTG")
                val fIBTG: com.example.myapplication.Model.Edamam_Response.Hit.Recipe.TotalDaily.FIBTG,
                @SerializedName("FOLDFE")
                val fOLDFE: com.example.myapplication.Model.Edamam_Response.Hit.Recipe.TotalDaily.FOLDFE,
                @SerializedName("K")
                val k: com.example.myapplication.Model.Edamam_Response.Hit.Recipe.TotalDaily.K,
                @SerializedName("MG")
                val mG: com.example.myapplication.Model.Edamam_Response.Hit.Recipe.TotalDaily.MG,
                @SerializedName("NA")
                val nA: com.example.myapplication.Model.Edamam_Response.Hit.Recipe.TotalDaily.NA,
                @SerializedName("NIA")
                val nIA: com.example.myapplication.Model.Edamam_Response.Hit.Recipe.TotalDaily.NIA,
                @SerializedName("P")
                val p: com.example.myapplication.Model.Edamam_Response.Hit.Recipe.TotalDaily.P,
                @SerializedName("PROCNT")
                val pROCNT: com.example.myapplication.Model.Edamam_Response.Hit.Recipe.TotalDaily.PROCNT,
                @SerializedName("RIBF")
                val rIBF: com.example.myapplication.Model.Edamam_Response.Hit.Recipe.TotalDaily.RIBF,
                @SerializedName("THIA")
                val tHIA: com.example.myapplication.Model.Edamam_Response.Hit.Recipe.TotalDaily.THIA,
                @SerializedName("TOCPHA")
                val tOCPHA: com.example.myapplication.Model.Edamam_Response.Hit.Recipe.TotalDaily.TOCPHA,
                @SerializedName("VITA_RAE")
                val vITARAE: com.example.myapplication.Model.Edamam_Response.Hit.Recipe.TotalDaily.VITARAE,
                @SerializedName("VITB12")
                val vITB12: com.example.myapplication.Model.Edamam_Response.Hit.Recipe.TotalDaily.VITB12,
                @SerializedName("VITB6A")
                val vITB6A: com.example.myapplication.Model.Edamam_Response.Hit.Recipe.TotalDaily.VITB6A,
                @SerializedName("VITC")
                val vITC: com.example.myapplication.Model.Edamam_Response.Hit.Recipe.TotalDaily.VITC,
                @SerializedName("VITD")
                val vITD: com.example.myapplication.Model.Edamam_Response.Hit.Recipe.TotalDaily.VITD,
                @SerializedName("VITK1")
                val vITK1: com.example.myapplication.Model.Edamam_Response.Hit.Recipe.TotalDaily.VITK1,
                @SerializedName("ZN")
                val zN: com.example.myapplication.Model.Edamam_Response.Hit.Recipe.TotalDaily.ZN
            ) {
                data class CA(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class CHOCDF(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class CHOLE(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class ENERCKCAL(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class FASAT(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class FAT(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class FE(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class FIBTG(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class FOLDFE(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class K(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class MG(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class NA(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class NIA(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class P(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class PROCNT(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class RIBF(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class THIA(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class TOCPHA(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class VITARAE(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class VITB12(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class VITB6A(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class VITC(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class VITD(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class VITK1(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class ZN(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )
            }

            data class TotalNutrients(
                @SerializedName("CA")
                val cA: com.example.myapplication.Model.Edamam_Response.Hit.Recipe.TotalNutrients.CA,
                @SerializedName("CHOCDF")
                val cHOCDF: com.example.myapplication.Model.Edamam_Response.Hit.Recipe.TotalNutrients.CHOCDF,
                @SerializedName("CHOLE")
                val cHOLE: com.example.myapplication.Model.Edamam_Response.Hit.Recipe.TotalNutrients.CHOLE,
                @SerializedName("ENERC_KCAL")
                val eNERCKCAL: com.example.myapplication.Model.Edamam_Response.Hit.Recipe.TotalNutrients.ENERCKCAL,
                @SerializedName("FAMS")
                val fAMS: com.example.myapplication.Model.Edamam_Response.Hit.Recipe.TotalNutrients.FAMS,
                @SerializedName("FAPU")
                val fAPU: com.example.myapplication.Model.Edamam_Response.Hit.Recipe.TotalNutrients.FAPU,
                @SerializedName("FASAT")
                val fASAT: com.example.myapplication.Model.Edamam_Response.Hit.Recipe.TotalNutrients.FASAT,
                @SerializedName("FAT")
                val fAT: com.example.myapplication.Model.Edamam_Response.Hit.Recipe.TotalNutrients.FAT,
                @SerializedName("FATRN")
                val fATRN: com.example.myapplication.Model.Edamam_Response.Hit.Recipe.TotalNutrients.FATRN,
                @SerializedName("FE")
                val fE: com.example.myapplication.Model.Edamam_Response.Hit.Recipe.TotalNutrients.FE,
                @SerializedName("FIBTG")
                val fIBTG: com.example.myapplication.Model.Edamam_Response.Hit.Recipe.TotalNutrients.FIBTG,
                @SerializedName("FOLAC")
                val fOLAC: com.example.myapplication.Model.Edamam_Response.Hit.Recipe.TotalNutrients.FOLAC,
                @SerializedName("FOLDFE")
                val fOLDFE: com.example.myapplication.Model.Edamam_Response.Hit.Recipe.TotalNutrients.FOLDFE,
                @SerializedName("FOLFD")
                val fOLFD: com.example.myapplication.Model.Edamam_Response.Hit.Recipe.TotalNutrients.FOLFD,
                @SerializedName("K")
                val k: com.example.myapplication.Model.Edamam_Response.Hit.Recipe.TotalNutrients.K,
                @SerializedName("MG")
                val mG: com.example.myapplication.Model.Edamam_Response.Hit.Recipe.TotalNutrients.MG,
                @SerializedName("NA")
                val nA: com.example.myapplication.Model.Edamam_Response.Hit.Recipe.TotalNutrients.NA,
                @SerializedName("NIA")
                val nIA: com.example.myapplication.Model.Edamam_Response.Hit.Recipe.TotalNutrients.NIA,
                @SerializedName("P")
                val p: com.example.myapplication.Model.Edamam_Response.Hit.Recipe.TotalNutrients.P,
                @SerializedName("PROCNT")
                val pROCNT: com.example.myapplication.Model.Edamam_Response.Hit.Recipe.TotalNutrients.PROCNT,
                @SerializedName("RIBF")
                val rIBF: com.example.myapplication.Model.Edamam_Response.Hit.Recipe.TotalNutrients.RIBF,
                @SerializedName("SUGAR")
                val sUGAR: com.example.myapplication.Model.Edamam_Response.Hit.Recipe.TotalNutrients.SUGAR,
                @SerializedName("THIA")
                val tHIA: com.example.myapplication.Model.Edamam_Response.Hit.Recipe.TotalNutrients.THIA,
                @SerializedName("TOCPHA")
                val tOCPHA: com.example.myapplication.Model.Edamam_Response.Hit.Recipe.TotalNutrients.TOCPHA,
                @SerializedName("VITA_RAE")
                val vITARAE: com.example.myapplication.Model.Edamam_Response.Hit.Recipe.TotalNutrients.VITARAE,
                @SerializedName("VITB12")
                val vITB12: com.example.myapplication.Model.Edamam_Response.Hit.Recipe.TotalNutrients.VITB12,
                @SerializedName("VITB6A")
                val vITB6A: com.example.myapplication.Model.Edamam_Response.Hit.Recipe.TotalNutrients.VITB6A,
                @SerializedName("VITC")
                val vITC: com.example.myapplication.Model.Edamam_Response.Hit.Recipe.TotalNutrients.VITC,
                @SerializedName("VITD")
                val vITD: com.example.myapplication.Model.Edamam_Response.Hit.Recipe.TotalNutrients.VITD,
                @SerializedName("VITK1")
                val vITK1: com.example.myapplication.Model.Edamam_Response.Hit.Recipe.TotalNutrients.VITK1,
                @SerializedName("WATER")
                val wATER: com.example.myapplication.Model.Edamam_Response.Hit.Recipe.TotalNutrients.WATER,
                @SerializedName("ZN")
                val zN: com.example.myapplication.Model.Edamam_Response.Hit.Recipe.TotalNutrients.ZN
            ) {
                data class CA(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class CHOCDF(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class CHOLE(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class ENERCKCAL(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class FAMS(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class FAPU(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class FASAT(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class FAT(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class FATRN(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class FE(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class FIBTG(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class FOLAC(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class FOLDFE(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class FOLFD(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class K(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class MG(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class NA(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class NIA(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class P(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class PROCNT(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class RIBF(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class SUGAR(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class THIA(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class TOCPHA(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class VITARAE(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class VITB12(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class VITB6A(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class VITC(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class VITD(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class VITK1(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class WATER(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class ZN(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )
            }
        }
    }
}