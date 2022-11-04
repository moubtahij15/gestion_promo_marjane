<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Youcode
  Date: 30/10/2022
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/tailwindcss/2.0.2/tailwind.min.css">

    <script defer src="https://unpkg.com/alpinejs@3.10.2/dist/cdn.min.js"></script>
    <link rel="stylesheet" href="https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css"/>

</head>
<body>
<!-- component -->
<!-- This is an example component -->
<div>
    <nav class="bg-white border-b border-gray-200 fixed z-30 w-full">
        <div class="px-3 py-3 lg:px-5 lg:pl-3">
            <div class="flex items-center justify-between">
                <div class="flex items-center justify-start">
                    <button id="toggleSidebarMobile" aria-expanded="true" aria-controls="sidebar"
                            class="lg:hidden mr-2 text-gray-600 hover:text-gray-900 cursor-pointer p-2 hover:bg-gray-100 focus:bg-gray-100 focus:ring-2 focus:ring-gray-100 rounded">
                        <svg id="toggleSidebarMobileHamburger" class="w-6 h-6" fill="currentColor" viewBox="0 0 20 20"
                             xmlns="http://www.w3.org/2000/svg">
                            <path fill-rule="evenodd"
                                  d="M3 5a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1zM3 10a1 1 0 011-1h6a1 1 0 110 2H4a1 1 0 01-1-1zM3 15a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1z"
                                  clip-rule="evenodd"></path>
                        </svg>
                        <svg id="toggleSidebarMobileClose" class="w-6 h-6 hidden" fill="currentColor"
                             viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
                            <path fill-rule="evenodd"
                                  d="M4.293 4.293a1 1 0 011.414 0L10 8.586l4.293-4.293a1 1 0 111.414 1.414L11.414 10l4.293 4.293a1 1 0 01-1.414 1.414L10 11.414l-4.293 4.293a1 1 0 01-1.414-1.414L8.586 10 4.293 5.707a1 1 0 010-1.414z"
                                  clip-rule="evenodd"></path>
                        </svg>
                    </button>
                    <a href="#" class="text-xl font-bold flex items-center lg:ml-2.5">
                        <img src="https://appsgeyser.io/geticon.php?widget=Marjane%20%D9%85%D8%B1%D8%AC%D8%A7%D9%86_7131104&width=512"
                             class="h-12 mr-2" alt="Windster Logo">
                        <span class="self-center whitespace-nowrap text-blue-800 ">Marjane</span>
                    </a>
                </div>


            </div>
        </div>

    </nav>
    <div class="flex overflow-hidden bg-white pt-16">
        <aside id="sidebar"
               class="fixed hidden z-20 h-full top-0 left-0 pt-16 flex lg:flex flex-shrink-0 flex-col w-64 transition-width duration-75"
               aria-label="Sidebar">
            <div class="relative flex-1 flex flex-col min-h-0 border-r border-gray-200 bg-white pt-0">
                <div class="flex-1 flex flex-col pt-5 pb-4 overflow-y-auto">
                    <div class="flex-1 px-3 bg-white divide-y space-y-1">
                        <ul class="space-y-2 pb-2">
                            <li>
                                <form action="#" method="GET" class="lg:hidden">
                                    <label for="mobile-search" class="sr-only">Search</label>
                                    <div class="relative">
                                        <div class="absolute inset-y-0 left-0 pl-3 flex items-center pointer-events-none">
                                            <svg class="w-5 h-5 text-gray-500" fill="currentColor" viewBox="0 0 20 20"
                                                 xmlns="http://www.w3.org/2000/svg">
                                                <path d="M5 3a2 2 0 00-2 2v2a2 2 0 002 2h2a2 2 0 002-2V5a2 2 0 00-2-2H5zM5 11a2 2 0 00-2 2v2a2 2 0 002 2h2a2 2 0 002-2v-2a2 2 0 00-2-2H5zM11 5a2 2 0 012-2h2a2 2 0 012 2v2a2 2 0 01-2 2h-2a2 2 0 01-2-2V5zM11 13a2 2 0 012-2h2a2 2 0 012 2v2a2 2 0 01-2 2h-2a2 2 0 01-2-2v-2z"></path>
                                            </svg>
                                        </div>
                                        <input type="text" name="email" id="mobile-search"
                                               class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-cyan-600 focus:ring-cyan-600 block w-full pl-10 p-2.5"
                                               placeholder="Search">
                                    </div>
                                </form>
                            </li>
                            <li>
                                <a href="#"
                                   class="text-base text-gray-900 font-normal rounded-lg flex items-center p-2 hover:bg-gray-100 group">
                                    <svg class="w-6 h-6 text-gray-500 group-hover:text-gray-900 transition duration-75"
                                         fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
                                        <path d="M2 10a8 8 0 018-8v8h8a8 8 0 11-16 0z"></path>
                                        <path d="M12 2.252A8.014 8.014 0 0117.748 8H12V2.252z"></path>
                                    </svg>
                                    <span class="ml-3">Dashboard</span>
                                </a>
                            </li>


                            <li>
                                <a href="http://localhost:8080/AdminStore/Responsable"
                                   class="text-base text-gray-900 font-normal rounded-lg hover:bg-gray-100 flex items-center p-2 group ">
                                    <svg class="w-6 h-6 text-gray-500 flex-shrink-0 group-hover:text-gray-900 transition duration-75"
                                         fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
                                        <path fill-rule="evenodd"
                                              d="M10 9a3 3 0 100-6 3 3 0 000 6zm-7 9a7 7 0 1114 0H3z"
                                              clip-rule="evenodd"></path>
                                    </svg>

                                    <span class="ml-3 flex-1 whitespace-nowrap">Responsable Rayon</span>
                                </a>
                            </li>
                            <li>
                                <a href="#"
                                   class="text-base text-gray-900 font-normal rounded-lg hover:bg-gray-100 flex items-center p-2 group ">
                                    <svg class="w-6 h-6 text-gray-500 flex-shrink-0 group-hover:text-gray-900 transition duration-75"
                                         fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
                                        <path fill-rule="evenodd"
                                              d="M10 2a4 4 0 00-4 4v1H5a1 1 0 00-.994.89l-1 9A1 1 0 004 18h12a1 1 0 00.994-1.11l-1-9A1 1 0 0015 7h-1V6a4 4 0 00-4-4zm2 5V6a2 2 0 10-4 0v1h4zm-6 3a1 1 0 112 0 1 1 0 01-2 0zm7-1a1 1 0 100 2 1 1 0 000-2z"
                                              clip-rule="evenodd"></path>
                                    </svg>
                                    <span class="ml-3 flex-1 whitespace-nowrap">Promotion</span>
                                </a>
                            </li>
                            <li>
                                <a href="#"
                                   class="text-base text-gray-900 font-normal rounded-lg hover:bg-gray-100 flex items-center p-2 group ">
                                    <svg class="w-6 h-6 text-gray-500 flex-shrink-0 group-hover:text-gray-900 transition duration-75"
                                         fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
                                        <path fill-rule="evenodd"
                                              d="M3 3a1 1 0 00-1 1v12a1 1 0 102 0V4a1 1 0 00-1-1zm10.293 9.293a1 1 0 001.414 1.414l3-3a1 1 0 000-1.414l-3-3a1 1 0 10-1.414 1.414L14.586 9H7a1 1 0 100 2h7.586l-1.293 1.293z"
                                              clip-rule="evenodd"></path>
                                    </svg>
                                    <span class="ml-3 flex-1 whitespace-nowrap">Sign Out</span>
                                </a>
                            </li>

                        </ul>

                    </div>
                </div>
            </div>
        </aside>
        <div class="bg-gray-900 opacity-50 hidden fixed inset-0 z-10" id="sidebarBackdrop"></div>
        <div id="main-content" class="h-full w-full bg-gray-50 relative overflow-y-auto lg:ml-64">
            <main>
                <div class="pt-6 px-4">
                    <div class="mt-4 w-full grid grid-cols-1 md:grid-cols-2 xl:grid-cols-3 gap-4">
                        <div class="bg-white shadow rounded-lg p-4 sm:p-6 xl:p-8 ">
                            <div class="flex items-center">
                                <div class="flex-shrink-0">
                                    <span class="text-2xl sm:text-3xl leading-none font-bold text-gray-900">2,340</span>
                                    <h3 class="text-base font-normal text-gray-500">pending promotion</h3>
                                </div>
                                <div class="ml-5 w-0 flex items-center justify-end flex-1 text-green-500 text-base font-bold">
                                    14.6%
                                    <svg class="w-5 h-5" fill="currentColor" viewBox="0 0 20 20"
                                         xmlns="http://www.w3.org/2000/svg">
                                        <path fill-rule="evenodd"
                                              d="M5.293 7.707a1 1 0 010-1.414l4-4a1 1 0 011.414 0l4 4a1 1 0 01-1.414 1.414L11 5.414V17a1 1 0 11-2 0V5.414L6.707 7.707a1 1 0 01-1.414 0z"
                                              clip-rule="evenodd"></path>
                                    </svg>
                                </div>
                            </div>
                        </div>
                        <div class="bg-white shadow rounded-lg p-4 sm:p-6 xl:p-8 ">
                            <div class="flex items-center">
                                <div class="flex-shrink-0">
                                    <span class="text-2xl sm:text-3xl leading-none font-bold text-gray-900">5,355</span>
                                    <h3 class="text-base font-normal text-gray-500">Accepted promotion</h3>
                                </div>
                                <div class="ml-5 w-0 flex items-center justify-end flex-1 text-green-500 text-base font-bold">
                                    32.9%
                                    <svg class="w-5 h-5" fill="currentColor" viewBox="0 0 20 20"
                                         xmlns="http://www.w3.org/2000/svg">
                                        <path fill-rule="evenodd"
                                              d="M5.293 7.707a1 1 0 010-1.414l4-4a1 1 0 011.414 0l4 4a1 1 0 01-1.414 1.414L11 5.414V17a1 1 0 11-2 0V5.414L6.707 7.707a1 1 0 01-1.414 0z"
                                              clip-rule="evenodd"></path>
                                    </svg>
                                </div>
                            </div>
                        </div>
                        <div class="bg-white shadow rounded-lg p-4 sm:p-6 xl:p-8 ">
                            <div class="flex items-center">
                                <div class="flex-shrink-0">
                                    <span class="text-2xl sm:text-3xl leading-none font-bold text-gray-900">385</span>
                                    <h3 class="text-base font-normal text-gray-500">Refused promotion</h3>
                                </div>
                                <div class="ml-5 w-0 flex items-center justify-end flex-1 text-red-500 text-base font-bold">
                                    -2.7%
                                    <svg class="w-5 h-5" fill="currentColor" viewBox="0 0 20 20"
                                         xmlns="http://www.w3.org/2000/svg">
                                        <path fill-rule="evenodd"
                                              d="M14.707 12.293a1 1 0 010 1.414l-4 4a1 1 0 01-1.414 0l-4-4a1 1 0 111.414-1.414L9 14.586V3a1 1 0 012 0v11.586l2.293-2.293a1 1 0 011.414 0z"
                                              clip-rule="evenodd"></path>
                                    </svg>
                                </div>
                            </div>
                        </div>
                    </div>

                    <%--                    section 2 : promotion / responsable--%>
                    <div class="w-full grid grid-cols-1 xl:grid-cols-2 2xl:grid-cols-3 mt-4 gap-4"
                         x-data="{ open: ${type_sous_categorie} ,type:${type_sous_categorie}}">
                        <%--                        promotion--%>
                        <div class="bg-white shadow rounded-lg p-4 sm:p-6 xl:p-8  2xl:col-span-2">
                            <div class="flex items-center justify-between mb-4">
                                <div class="flex-shrink-0">
                                    <span class="text-2xl sm:text-3xl leading-none font-bold text-gray-900">Promotions</span>
                                    <h3 class="   text-base font-normal text-gray-500">Derniers Promotions</h3>


                                </div>
                                <div class="flex items-center justify-end flex-1 text-green-500 text-base font-bold">

                                    <div class="flex-shrink-0">
                                        <a href="#"
                                           x-on:click="open = ! open"
                                           class="text-sm font-medium text-cyan-600 hover:bg-gray-100 rounded-lg p-2"
                                           value="dfs">
                                            <span x-text="(!open)?'Ajouter Promotion':'Annuler'"></span>
                                        </a>
                                    </div>
                                </div>
                            </div>
                            <%--                            voir promo--%>
                            <div x-show="!open" class="block w-full overflow-x-auto">

                                <table class="items-center w-full bg-transparent border-collapse">
                                    <thead>
                                    <tr>
                                        <th class="px-4 bg-gray-50 text-gray-700 align-middle py-3 text-xs font-semibold text-center uppercase border-l-0 border-r-0 whitespace-nowrap">
                                            Date Debut
                                        </th>
                                        <th class="px-4 bg-gray-50 text-gray-700 align-middle py-3 text-xs font-semibold text-center uppercase border-l-0 border-r-0 whitespace-nowrap min-w-140-px">
                                            Date Fin
                                        </th>
                                        <th class="px-4 bg-gray-50 text-gray-700 align-middle py-3 text-xs font-semibold text-center uppercase border-l-0 border-r-0 whitespace-nowrap min-w-140-px">
                                            Pourcentage
                                        </th>
                                        <th class="px-4 bg-gray-50 text-gray-700 align-middle py-3 text-xs font-semibold text-center uppercase border-l-0 border-r-0 whitespace-nowrap min-w-140-px">
                                            Fidélité
                                        </th>
                                        <th class="px-4 bg-gray-50 text-gray-700 align-middle py-3 text-xs font-semibold text-center uppercase border-l-0 border-r-0 whitespace-nowrap min-w-140-px">
                                            Type
                                        </th>
                                        <th class="px-4 bg-gray-50 text-gray-700 align-middle py-3 text-xs font-semibold text-center uppercase border-l-0 border-r-0 whitespace-nowrap min-w-140-px">
                                            Rayon/sous Categorie
                                        </th>
                                        <th class="px-4 bg-gray-50 text-gray-700 align-middle py-3 text-xs font-semibold text-center uppercase border-l-0 border-r-0 whitespace-nowrap min-w-140-px">
                                            Status
                                        </th>
                                        <th class="px-4 bg-gray-50 text-gray-700 align-middle py-3 text-xs font-semibold text-center uppercase border-l-0 border-r-0 whitespace-nowrap min-w-140-px">
                                            Action
                                        </th>

                                    </tr>
                                    </thead>
                                    <tbody class="divide-y divide-gray-100">
                                    <c:forEach items="${Promotions}" var="promo">
                                        <tr class="text-gray-500">
                                            <td class="border-t-0 px-4 align-middle text-xs text-center font-medium text-gray-900 whitespace-nowrap p-4">${promo.getDateDebut()}</td>
                                            <td class="border-t-0 px-4 align-center text-xs text-center font-medium text-gray-900 whitespace-nowrap p-4">${promo.getDateFin()}</td>
                                            <td class="border-t-0 px-4 align-middle text-center text-xs font-medium text-gray-900 whitespace-nowrap p-4">${promo.getPoucentage()}
                                                %
                                            </td>
                                            <td class="border-t-0 px-4 align-middle text-xs text-center font-medium text-gray-900 whitespace-nowrap p-4">${promo.getFedelite()}</td>
                                            <td class="border-t-0 px-4 align-middle text-xs  text-center font-medium text-gray-900 whitespace-nowrap p-4">${promo.getType()}</td>
                                            <td class="border-t-0 px-4 align-middle text-xs text-center font-medium text-gray-900 whitespace-nowrap p-4">${(promo.getType().equals('SUBCATEGORIE'))?promo.getSousCategorieByIdSousCategorie().getNom():promo.getCategorieByIdCategorie().getNom()}</td>
                                            <td class="border-t-0 px-4 align-middle text-xs text-center font-medium text-gray-900 whitespace-nowrap p-4">${promo.getStatut()}</td>
                                            <td class="border-t-0 px-4 align-middle text-xs text-center font-medium text-gray-900 whitespace-nowrap p-4">
                                                <button class="mb-2 md:mb-0 w-1/2 bg-white px-5 py-2 text-sm shadow-sm font-medium tracking-wider border text-gray-600 rounded-full hover:shadow-lg hover:bg-gray-100">
                                                    Editer
                                                </button>
                                                <a href="http://localhost:8080/AdminStore/deletePromo?idPromo=${promo.getId()}"

                                                   class="mb-2 md:mb-0 bg-red-500  w-1/2 border border-red-500 px-5 py-2 text-sm shadow-sm font-medium tracking-wider text-white rounded-full hover:shadow-lg hover:bg-red-600">
                                                    Suprrimer
                                                </a>


                                            </td>

                                        </tr>
                                    </c:forEach>

                                    </tbody>
                                </table>
                            </div>

                            <%--                            add promotion--%>

                            <div x-show="open" class=" bg-white  shadow rounded-lg  p-4 sm:p-6  w-full ">
                                <c:if test="${erreur.size()!=0}">
                                    <div class="bg-red-50 border-l-8 border-red-900 w-full mb-2">
                                        <div class="flex items-center">
                                            <div class="p-2">
                                                <div class="flex items-center">
                                                    <div class="ml-2">
                                                        <svg class="h-8 w-8 text-red-900 mr-2 cursor-pointer"
                                                             xmlns="http://www.w3.org/2000/svg" fill="none"
                                                             viewBox="0 0 24 24"
                                                             stroke="currentColor">
                                                            <path stroke-linecap="round" stroke-linejoin="round"
                                                                  stroke-width="2"
                                                                  d="M10 14l2-2m0 0l2-2m-2 2l-2-2m2 2l2 2m7-2a9 9 0 11-18 0 9 9 0 0118 0z"></path>
                                                        </svg>
                                                    </div>
                                                    <p class="px-6 py-4 text-red-900 font-semibold text-lg">Please
                                                        corriger les
                                                        erreurs
                                                        suivant :
                                                    </p>
                                                </div>
                                                <div class="px-16 mb-4">
                                                    <c:forEach items="${erreur}" var="erro">
                                                        <li class="text-md font-bold text-red-500 text-sm">${erro}</li>
                                                    </c:forEach>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </c:if>
                                <form action="AdminStore/addPromo" method="post" class="space-y-4">
                                    <div class="grid grid-cols-1 gap-4 sm:grid-cols-2">
                                        <div>
                                            <%--                                        <label class="sr-only" for="date_depart">Date depart</label>--%>
                                            <label class="block text-grey-darker text-sm font-bold mb-1 px-2"
                                                   for="date_depart"> Date Debut</label>

                                            <input
                                                    class="w-full rounded-md border border-[#e0e0e0] bg-white py-3 px-6 text-base font-medium text-[#6B7280] outline-none focus:border-[#6A64F1] focus:shadow-md"
                                            <%--                                                placeholder="Email address"--%>
                                                    name="date_depart"
                                                    type="date"
                                                    id="date_depart"
                                            />
                                        </div>

                                        <div>
                                            <%--                                        <label class="sr-only" for="date_fin">Date fin</label>--%>
                                            <label class="block text-grey-darker text-sm font-bold mb-1 px-2"
                                                   for="date_fin"> Date Fin</label>

                                            <input
                                                    class="w-full rounded-md border border-[#e0e0e0] bg-white py-3 px-6 text-base font-medium text-[#6B7280] outline-none focus:border-[#6A64F1] focus:shadow-md"
                                            <%--                                                placeholder="Email address"--%>
                                                    name="date_fin"

                                                    type="date"
                                                    id="date_fin"
                                            />
                                        </div>

                                    </div>

                                    <div class="grid grid-cols-1 gap-4 sm:grid-cols-2">
                                        <div>
                                            <label class="block text-grey-darker text-sm font-bold mb-1 px-2"
                                                   for="pourcentage"> Pourcentage</label>

                                            <input
                                                    class="w-full rounded-md border border-[#e0e0e0] bg-white py-3 px-6 text-base font-medium text-[#6B7280] outline-none focus:border-[#6A64F1] focus:shadow-md"
                                                    placeholder="Pourcentage"
                                                    type="number"
                                                    id="pourcentage"
                                                    name="pourcentage"
                                            />
                                        </div>
                                        <%--                                        radio type--%>
                                        <div>


                                            <label class="block text-grey-darker text-sm font-bold mb-1 px-2"
                                                   for="type"> Type</label>
                                            <fieldset class="flex flex-wrap gap-3 " id="type">

                                                <div>

                                                    <input
                                                            type="radio"
                                                            name="type"
                                                            value="CATEGORIE"
                                                            id="Categorie"
                                                            class="peer hidden [&:checked_+_label_svg]:block"
                                                            @click="type=false"
                                                            <c:if test="${type_sous_categorie==false}">
                                                                checked
                                                            </c:if>

                                                    />

                                                    <label
                                                            for="Categorie"
                                                            class="flex cursor-pointer items-center justify-center gap-2 rounded-md border border-gray-100 py-2 px-3 text-gray-900 hover:border-gray-200 peer-checked:border-blue-500 peer-checked:bg-blue-500 peer-checked:text-white"
                                                    >
                                                        <svg
                                                                class="hidden h-5 w-5"
                                                                xmlns="http://www.w3.org/2000/svg"
                                                                viewBox="0 0 20 20"
                                                                fill="currentColor"
                                                        >
                                                            <path
                                                                    fill-rule="evenodd"
                                                                    d="M10 18a8 8 0 100-16 8 8 0 000 16zm3.707-9.293a1 1 0 00-1.414-1.414L9 10.586 7.707 9.293a1 1 0 00-1.414 1.414l2 2a1 1 0 001.414 0l4-4z"
                                                                    clip-rule="evenodd"
                                                            />
                                                        </svg>

                                                        <p class="text-sm font-medium">Categorie</p>
                                                    </label>
                                                </div>
                                                <div>
                                                    <input
                                                            type="radio"
                                                            name="type"
                                                            value="SUBCATEGORIE"
                                                            id="sous_categorie"
                                                            class="peer hidden [&:checked_+_label_svg]:block"
                                                            @click="type=true"
                                                            <c:if test="${type_sous_categorie==true}">
                                                                checked
                                                            </c:if>
                                                    />

                                                    <label
                                                            for="sous_categorie"
                                                            class="flex cursor-pointer items-center justify-center gap-2 rounded-md border border-gray-100 py-2 px-3 text-gray-900 hover:border-gray-200 peer-checked:border-blue-500 peer-checked:bg-blue-500 peer-checked:text-white"
                                                    >
                                                        <svg
                                                                class="hidden h-5 w-5"
                                                                xmlns="http://www.w3.org/2000/svg"
                                                                viewBox="0 0 20 20"
                                                                fill="currentColor"
                                                        >
                                                            <path
                                                                    fill-rule="evenodd"
                                                                    d="M10 18a8 8 0 100-16 8 8 0 000 16zm3.707-9.293a1 1 0 00-1.414-1.414L9 10.586 7.707 9.293a1 1 0 00-1.414 1.414l2 2a1 1 0 001.414 0l4-4z"
                                                                    clip-rule="evenodd"
                                                            />
                                                        </svg>

                                                        <p class="text-sm font-medium">sous Categorie</p>
                                                    </label>
                                                </div>
                                            </fieldset>
                                            <%--                                     end    radio type--%>
                                        </div>
                                    </div>


                                    <%--                        dropdown--%>
                                    <div class="grid grid-cols-1 gap-4 sm:grid-cols-2">

                                        <div>

                                            <label for="countries"
                                                   class="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-400">Select
                                                categorie</label>
                                            <select id="countries"
                                                    name="categorie"
                                                    x-on:change=" (type)? (window.location=('http://localhost:8080/AdminStore/sousCategorie?selected_categorie='+$el.value+'')) : '' "
                                                    class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
                                                <%--                                                <option selected>Choose a Categorie</option>--%>
                                                <c:forEach items="${categorieList}" var="categorie">
                                                    <c:if test="${categorie.getId()==selectedCategorie}">
                                                        <option SELECTED value=${categorie.getId()}>
                                                                ${categorie.getNom()}
                                                        </option>
                                                    </c:if>
                                                    <c:if test="${categorie.getId()!=selectedCategorie}">
                                                        <option value=${categorie.getId()}>
                                                                ${categorie.getNom()}
                                                        </option>
                                                    </c:if>


                                                </c:forEach>


                                            </select>
                                        </div>

                                        <div x-show="type">

                                            <label for="countsries"
                                                   class="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-400">Select
                                                sou categorie</label>
                                            <SELECT id="countsries"
                                                    name="sous_categorie"
                                                    class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg
                                            focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5
                                            dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400
                                            dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">

                                                <option selected>Choose a country</option>

                                                <c:forEach items="${souCategoeie}"
                                                           var="souscategorie">


                                                    <option value=${souscategorie.getId()}>${souscategorie.getNom()}</option>
                                                </c:forEach>
                                            </SELECT>


                                        </div>
                                    </div>

                                    <div class="mt-4">
                                        <button
                                                type="submit"
                                                class="inline-flex w-full items-center justify-center rounded-lg bg-black px-5 py-3 text-white sm:w-auto"
                                        >
                                            <span class="font-medium"> Ajouter </span>

                                            <svg
                                                    xmlns="http://www.w3.org/2000/svg"
                                                    class="ml-3 h-5 w-5"
                                                    fill="none"
                                                    viewBox="0 0 24 24"
                                                    stroke="currentColor"
                                            >
                                                <path
                                                        stroke-linecap="round"
                                                        stroke-linejoin="round"
                                                        stroke-width="2"
                                                        d="M14 5l7 7m0 0l-7 7m7-7H3"
                                                />
                                            </svg>
                                        </button>


                                        <%--                                        dropdown catgeorie--%>


                                    </div>
                                </form>
                            </div>

                            <%--                    end add promotion--%>

                            <%--                            <div id="main-chart"></div>--%>
                        </div>
                        <%--                        end promotion--%>

                        <%--
                        <%--                            respo--%>
                        <div class="bg-white shadow rounded-lg p-4 sm:p-6 xl:p-8 ">
                            <div class="mb-4 flex items-center justify-between">
                                <div>
                                    <h3 class="text-xl font-bold text-gray-900 mb-2">Responsable de Rayon</h3>
                                    <span class="text-base font-normal text-gray-500">Responsable de Rayon avec leurs Rayon</span>
                                </div>
                                <div class="flex-shrink-0">
                                    <a href="http://localhost:8080/AdminStore/Responsable"

                                       class="text-sm font-medium text-cyan-600 hover:bg-gray-100 rounded-lg p-2">Voir
                                        Plus</a>
                                </div>
                            </div>
                            <div class="flex flex-col mt-8">
                                <div class="overflow-x-auto rounded-lg">
                                    <div class="align-middle inline-block min-w-full">
                                        <div class="shadow overflow-hidden sm:rounded-lg">
                                            <table class="min-w-full divide-y divide-gray-200">
                                                <thead class="bg-gray-50">
                                                <tr>
                                                    <th scope="col"
                                                        class="p-4 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                                                        Responsable
                                                    </th>
                                                    <th scope="col"
                                                        class="p-4 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                                                        Rayon
                                                    </th>

                                                </tr>
                                                </thead>
                                                <tbody class="bg-white">


                                                <c:forEach items="${ResponsablesRayon}" var="respo">
                                                    <tr>
                                                        <td class="p-4 whitespace-nowrap text-sm font-normal text-gray-900">
                                                            <span class="font-semibold"> ${respo.getName()}</span>
                                                        </td>
                                                        <td class="p-4 whitespace-nowrap text-sm font-normal text-gray-500">
                                                                ${respo.getCategorieByIdCategorie().getNom()}
                                                        </td>

                                                    </tr>
                                                </c:forEach>


                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <%--                        end respo--%>
                    </div>
                    <%--                  end  section 2 : promotion / responsable--%>
                    <%--

                                        <%--                        <div class="bg-white shadow rounded-lg p-4 sm:p-6 xl:p-8 ">--%>
                    <%--                            <h3 class="text-xl leading-none font-bold text-gray-900 mb-10">Acquisition Overview</h3>--%>

                    <%--                        </div>--%>
            </main>
            <footer class="bg-white md:flex md:items-center md:justify-between shadow rounded-lg p-4 md:p-6 xl:p-8 my-6 mx-4">
                <ul class="flex items-center flex-wrap mb-6 md:mb-0">
                    <li><a href="#" class="text-sm font-normal text-gray-500 hover:underline mr-4 md:mr-6">Terms and
                        conditions</a></li>
                    <li><a href="#" class="text-sm font-normal text-gray-500 hover:underline mr-4 md:mr-6">Privacy
                        Policy</a></li>
                    <li><a href="#" class="text-sm font-normal text-gray-500 hover:underline mr-4 md:mr-6">Licensing</a>
                    </li>
                    <li><a href="#" class="text-sm font-normal text-gray-500 hover:underline mr-4 md:mr-6">Cookie
                        Policy</a></li>
                    <li><a href="#" class="text-sm font-normal text-gray-500 hover:underline">Contact</a></li>
                </ul>
                <div class="flex sm:justify-center space-x-6">
                    <a href="#" class="text-gray-500 hover:text-gray-900">
                        <svg class="h-5 w-5" fill="currentColor" viewBox="0 0 24 24" aria-hidden="true">
                            <path fill-rule="evenodd"
                                  d="M22 12c0-5.523-4.477-10-10-10S2 6.477 2 12c0 4.991 3.657 9.128 8.438 9.878v-6.987h-2.54V12h2.54V9.797c0-2.506 1.492-3.89 3.777-3.89 1.094 0 2.238.195 2.238.195v2.46h-1.26c-1.243 0-1.63.771-1.63 1.562V12h2.773l-.443 2.89h-2.33v6.988C18.343 21.128 22 16.991 22 12z"
                                  clip-rule="evenodd"/>
                        </svg>
                    </a>
                    <a href="#" class="text-gray-500 hover:text-gray-900">
                        <svg class="h-5 w-5" fill="currentColor" viewBox="0 0 24 24" aria-hidden="true">
                            <path fill-rule="evenodd"
                                  d="M12.315 2c2.43 0 2.784.013 3.808.06 1.064.049 1.791.218 2.427.465a4.902 4.902 0 011.772 1.153 4.902 4.902 0 011.153 1.772c.247.636.416 1.363.465 2.427.048 1.067.06 1.407.06 4.123v.08c0 2.643-.012 2.987-.06 4.043-.049 1.064-.218 1.791-.465 2.427a4.902 4.902 0 01-1.153 1.772 4.902 4.902 0 01-1.772 1.153c-.636.247-1.363.416-2.427.465-1.067.048-1.407.06-4.123.06h-.08c-2.643 0-2.987-.012-4.043-.06-1.064-.049-1.791-.218-2.427-.465a4.902 4.902 0 01-1.772-1.153 4.902 4.902 0 01-1.153-1.772c-.247-.636-.416-1.363-.465-2.427-.047-1.024-.06-1.379-.06-3.808v-.63c0-2.43.013-2.784.06-3.808.049-1.064.218-1.791.465-2.427a4.902 4.902 0 011.153-1.772A4.902 4.902 0 015.45 2.525c.636-.247 1.363-.416 2.427-.465C8.901 2.013 9.256 2 11.685 2h.63zm-.081 1.802h-.468c-2.456 0-2.784.011-3.807.058-.975.045-1.504.207-1.857.344-.467.182-.8.398-1.15.748-.35.35-.566.683-.748 1.15-.137.353-.3.882-.344 1.857-.047 1.023-.058 1.351-.058 3.807v.468c0 2.456.011 2.784.058 3.807.045.975.207 1.504.344 1.857.182.466.399.8.748 1.15.35.35.683.566 1.15.748.353.137.882.3 1.857.344 1.054.048 1.37.058 4.041.058h.08c2.597 0 2.917-.01 3.96-.058.976-.045 1.505-.207 1.858-.344.466-.182.8-.398 1.15-.748.35-.35.566-.683.748-1.15.137-.353.3-.882.344-1.857.048-1.055.058-1.37.058-4.041v-.08c0-2.597-.01-2.917-.058-3.96-.045-.976-.207-1.505-.344-1.858a3.097 3.097 0 00-.748-1.15 3.098 3.098 0 00-1.15-.748c-.353-.137-.882-.3-1.857-.344-1.023-.047-1.351-.058-3.807-.058zM12 6.865a5.135 5.135 0 110 10.27 5.135 5.135 0 010-10.27zm0 1.802a3.333 3.333 0 100 6.666 3.333 3.333 0 000-6.666zm5.338-3.205a1.2 1.2 0 110 2.4 1.2 1.2 0 010-2.4z"
                                  clip-rule="evenodd"/>
                        </svg>
                    </a>
                    <a href="#" class="text-gray-500 hover:text-gray-900">
                        <svg class="h-5 w-5" fill="currentColor" viewBox="0 0 24 24" aria-hidden="true">
                            <path d="M8.29 20.251c7.547 0 11.675-6.253 11.675-11.675 0-.178 0-.355-.012-.53A8.348 8.348 0 0022 5.92a8.19 8.19 0 01-2.357.646 4.118 4.118 0 001.804-2.27 8.224 8.224 0 01-2.605.996 4.107 4.107 0 00-6.993 3.743 11.65 11.65 0 01-8.457-4.287 4.106 4.106 0 001.27 5.477A4.072 4.072 0 012.8 9.713v.052a4.105 4.105 0 003.292 4.022 4.095 4.095 0 01-1.853.07 4.108 4.108 0 003.834 2.85A8.233 8.233 0 012 18.407a11.616 11.616 0 006.29 1.84"/>
                        </svg>
                    </a>
                    <a href="#" class="text-gray-500 hover:text-gray-900">
                        <svg class="h-5 w-5" fill="currentColor" viewBox="0 0 24 24" aria-hidden="true">
                            <path fill-rule="evenodd"
                                  d="M12 2C6.477 2 2 6.484 2 12.017c0 4.425 2.865 8.18 6.839 9.504.5.092.682-.217.682-.483 0-.237-.008-.868-.013-1.703-2.782.605-3.369-1.343-3.369-1.343-.454-1.158-1.11-1.466-1.11-1.466-.908-.62.069-.608.069-.608 1.003.07 1.531 1.032 1.531 1.032.892 1.53 2.341 1.088 2.91.832.092-.647.35-1.088.636-1.338-2.22-.253-4.555-1.113-4.555-4.951 0-1.093.39-1.988 1.029-2.688-.103-.253-.446-1.272.098-2.65 0 0 .84-.27 2.75 1.026A9.564 9.564 0 0112 6.844c.85.004 1.705.115 2.504.337 1.909-1.296 2.747-1.027 2.747-1.027.546 1.379.202 2.398.1 2.651.64.7 1.028 1.595 1.028 2.688 0 3.848-2.339 4.695-4.566 4.943.359.309.678.92.678 1.855 0 1.338-.012 2.419-.012 2.747 0 .268.18.58.688.482A10.019 10.019 0 0022 12.017C22 6.484 17.522 2 12 2z"
                                  clip-rule="evenodd"/>
                        </svg>
                    </a>
                    <a href="#" class="text-gray-500 hover:text-gray-900">
                        <svg class="h-5 w-5" fill="currentColor" viewBox="0 0 24 24" aria-hidden="true">
                            <path fill-rule="evenodd"
                                  d="M12 2C6.48 2 2 6.48 2 12s4.48 10 10 10c5.51 0 10-4.48 10-10S17.51 2 12 2zm6.605 4.61a8.502 8.502 0 011.93 5.314c-.281-.054-3.101-.629-5.943-.271-.065-.141-.12-.293-.184-.445a25.416 25.416 0 00-.564-1.236c3.145-1.28 4.577-3.124 4.761-3.362zM12 3.475c2.17 0 4.154.813 5.662 2.148-.152.216-1.443 1.941-4.48 3.08-1.399-2.57-2.95-4.675-3.189-5A8.687 8.687 0 0112 3.475zm-3.633.803a53.896 53.896 0 013.167 4.935c-3.992 1.063-7.517 1.04-7.896 1.04a8.581 8.581 0 014.729-5.975zM3.453 12.01v-.26c.37.01 4.512.065 8.775-1.215.25.477.477.965.694 1.453-.109.033-.228.065-.336.098-4.404 1.42-6.747 5.303-6.942 5.629a8.522 8.522 0 01-2.19-5.705zM12 20.547a8.482 8.482 0 01-5.239-1.8c.152-.315 1.888-3.656 6.703-5.337.022-.01.033-.01.054-.022a35.318 35.318 0 011.823 6.475 8.4 8.4 0 01-3.341.684zm4.761-1.465c-.086-.52-.542-3.015-1.659-6.084 2.679-.423 5.022.271 5.314.369a8.468 8.468 0 01-3.655 5.715z"
                                  clip-rule="evenodd"/>
                        </svg>
                    </a>
                </div>
            </footer>
            <p class="text-center text-sm text-gray-500 my-10">
                &copy; 2019-2021 <a href="#" class="hover:underline" target="_blank">Themesberg</a>. All rights
                reserved.
            </p>
        </div>
    </div>
    <script async defer src="https://buttons.github.io/buttons.js"></script>
    <script src="https://demo.themesberg.com/windster/app.bundle.js"></script>
</div>
</body>
</html>
